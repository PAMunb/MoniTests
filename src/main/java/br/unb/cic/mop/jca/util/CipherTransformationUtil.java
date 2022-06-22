package br.unb.cic.mop.jca.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CipherTransformationUtil {

    public static String alg(String transformation) {
       if(transformation.contains("/")) {
           return transformation.split("/")[0];
       }
       return transformation;
    }

    public static String mode(String transformation) {
        if(transformation.contains("/")) {
            return transformation.split("/")[1];
        }
        return "";
    }

    public static String pad(String transformation) {
        String[] arr = transformation.split("/");
        if(arr.length == 3) {
            return arr[2];
        }
        return "";
    }

    public static boolean isValid(String transformation) {
        List<String> modes = Arrays.asList("CBC", "GCM", "PCBC", "CTR", "CTS", "CFB", "OFB");
        HashMap<String, List<String>> padding = new HashMap<>();
        padding.put("CBC", Arrays.asList("PKCS5PADDING", "ISO10126PADDING", "PKCS5PADDING"));
        padding.put("PCBC", Arrays.asList("PKCS5PADDING", "ISO10126PADDING", "PKCS5PADDING"));
        padding.put("GCM", Arrays.asList("", "NOPADDING"));
        padding.put("CTR", Arrays.asList("", "NOPADDING"));
        padding.put("CTS", Arrays.asList("", "NOPADDING"));
        padding.put("CFB", Arrays.asList("", "NOPADDING"));
        padding.put("OFB", Arrays.asList("", "NOPADDING"));

        if(alg(transformation).equals("AES")) {
            if(modes.contains(mode(transformation))) {
                return padding.get(mode(transformation)).contains(pad(transformation).toUpperCase());
            }
        }
        else if(alg(transformation).equals("RSA")) {
            return mode(transformation).equals("") && pad(transformation).equalsIgnoreCase("");
        }
        return false;
    }
}
