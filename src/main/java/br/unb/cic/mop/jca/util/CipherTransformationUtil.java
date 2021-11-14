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
        padding.put("CBC", Arrays.asList("PKCS5Padding", "ISO10126Padding"));
        padding.put("PCBC", Arrays.asList("PKCS5Padding", "ISO10126Padding"));
        padding.put("GCM", Arrays.asList("", "NoPadding"));
        padding.put("CTR", Arrays.asList("", "NoPadding"));
        padding.put("CTS", Arrays.asList("", "NoPadding"));
        padding.put("CFB", Arrays.asList("", "NoPadding"));
        padding.put("OFB", Arrays.asList("", "NoPadding"));

        if(alg(transformation).equals("AES")) {
            if(modes.contains(mode(transformation))) {
                return padding.get(mode(transformation)).contains(pad(transformation));
            }
        }
        return false;
    }
}
