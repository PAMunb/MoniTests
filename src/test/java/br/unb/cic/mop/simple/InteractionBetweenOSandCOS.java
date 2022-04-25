package br.unb.cic.mop.simple;

import br.unb.cic.mop.test.Assertions;
import org.junit.Test;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.security.SecureRandom;

import java.security.spec.KeySpec;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class InteractionBetweenOSandCOS {
    @Test
    public void testIfOutputStreamWriterCallsCipherOutputStream() throws Exception {
        String OBFUSCATION_SALT = "Salty";
        String OBFUSCATION_PASSCODE = "NowIsTheTime";
        String ENCRYPT_ME = "InputTextToEncrypt";

        int IV_LENGTH = 16;

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[IV_LENGTH];
        random.nextBytes(iv);
        os.write(iv);
        os.flush();

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec keySpec = new PBEKeySpec(OBFUSCATION_PASSCODE.toCharArray(), OBFUSCATION_SALT.getBytes(StandardCharsets.UTF_8), 1024, 128);
        SecretKey secretKey = factory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "AES");
        IvParameterSpec parameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);

        CipherOutputStream cos = new CipherOutputStream(os, cipher);

        Writer w = new OutputStreamWriter(cos,java.nio.charset.StandardCharsets.UTF_8);
        w.write(ENCRYPT_ME);
        w.flush();

        cos.flush();
        cos.close();
    }
}