import br.unb.cic.mop.jca.eh.ErrorCollector;

import br.unb.cic.mop.jca.util.ExecutionContext;
import br.unb.cic.mop.test.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.spec.InvalidParameterSpecException;

public class BlockCipherTest {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
        ExecutionContext.instance().reset();
    }

    private Certificate loadCertificate() throws Exception {
        File ksInputFile = new File(getClass().getClassLoader().getResource("testInput-ks").getFile());
        InputStream fileIn = new FileInputStream(ksInputFile);
        KeyStore keyStore0 = KeyStore.getInstance("JKS");
        keyStore0.load(fileIn, "password".toCharArray());
        return keyStore0.getCertificate("certificate01");
    }

    @Ignore
    public void simpleTest() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(256);
        SecretKey key = keygen.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.update("secret".getBytes());
        cipherText = cipher.doFinal();
        Assertions.expectingEmptySetOfErrors();
    }

    @Ignore
    public void invalidTransformationTest() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(256);
        SecretKey key = keygen.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        cipher.update("secret".getBytes());
        cipher.doFinal();
        Assertions.expectingNonEmptySetOfErrors();
    }

    @Ignore
    public void invalidKeyTest() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("DES");
        keygen.init(56);
        SecretKey key = keygen.generateKey();

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        cipher.update("secret".getBytes());
        cipher.doFinal();
        Assertions.expectingNonEmptySetOfErrors();
    }

    @Ignore
    public void cipherValidTest1()
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {

        Certificate cert = null;
        Key wrappedKey = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore
    public void cipherValidTest2() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchProviderException {

        Certificate cert = null;
        Key wrappedKey = null;

        Cipher cipher0 = Cipher.getInstance("RSA", (String) null);
        cipher0.init(1, cert);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore
    public void cipherValidTest3()
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

        Certificate cert = null;
        Key wrappedKey = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert, secureRandom0);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    //TODO: This test case is not correct. There are a couple of mistakes.
    //  - we cannot use RSA with an AES key
    //  - we cannot call wrap using the DECRYPT_MODE (only WRAP_MODE). See the call cipher0.init(1, secretKey);
    //  - wrappedKey must not be null
    @Ignore
    public void wrongTestCase()
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        Key wrappedKey = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, secretKey);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest13()
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        Key wrappedKey = keyGenerator0.generateKey();

        Cipher cipher0 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher0.init(Cipher.WRAP_MODE, secretKey);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest14() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
            NoSuchAlgorithmException, InvalidKeyException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

        byte[] plainText = "secret".getBytes();

        Cipher cipher0 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher0.init(1, secretKey, secureRandom0);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest15() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
            NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        int num = 2022;// 0 leads to an empty genSeed... so we changed it.

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

        GCMParameterSpec gCMParameterSpec0 = new GCMParameterSpec(96, genSeed);
        Assertions.hasEnsuredPredicate(gCMParameterSpec0);
        Assertions.mustBeInAcceptingState(gCMParameterSpec0);

        byte[] plainText = "secret".getBytes();

        Cipher cipher0 = Cipher.getInstance("AES/GCM/NoPadding");
        cipher0.init(1, secretKey, gCMParameterSpec0);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore //TODO: We could not fix this test case.
    public void cipherValidTest16()
            throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException,
            InvalidParameterSpecException, InvalidKeyException, InvalidAlgorithmParameterException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        int exponentSize = 0;
        int primeSize = 0;

        DHGenParameterSpec dHGenParameterSpec0 = new DHGenParameterSpec(primeSize, exponentSize);
        Assertions.hasEnsuredPredicate(dHGenParameterSpec0);
        Assertions.mustBeInAcceptingState(dHGenParameterSpec0);

        AlgorithmParameters algorithmParameters0 = AlgorithmParameters.getInstance("AES");
        algorithmParameters0.init(dHGenParameterSpec0);
        Assertions.hasEnsuredPredicate(algorithmParameters0);
        Assertions.mustBeInAcceptingState(algorithmParameters0);

        byte[] plainText = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, secretKey, algorithmParameters0);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest17() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
            NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        int num = 2022;

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

        GCMParameterSpec gCMParameterSpec0 = new GCMParameterSpec(96, genSeed);
        Assertions.hasEnsuredPredicate(gCMParameterSpec0);
        Assertions.mustBeInAcceptingState(gCMParameterSpec0);

        byte[] plainText = "secret".getBytes();

        Cipher cipher0 = Cipher.getInstance("AES/GCM/NoPadding");
        cipher0.init(1, secretKey, gCMParameterSpec0, secureRandom0);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore //TODO: We could not fix this test case.
    public void cipherValidTest18()
            throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException,
            InvalidParameterSpecException, InvalidKeyException, InvalidAlgorithmParameterException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        int exponentSize = 0;
        int primeSize = 0;

        DHGenParameterSpec dHGenParameterSpec0 = new DHGenParameterSpec(primeSize, exponentSize);
        Assertions.hasEnsuredPredicate(dHGenParameterSpec0);
        Assertions.mustBeInAcceptingState(dHGenParameterSpec0);

        AlgorithmParameters algorithmParameters0 = AlgorithmParameters.getInstance("AES");
        algorithmParameters0.init(dHGenParameterSpec0);
        Assertions.hasEnsuredPredicate(algorithmParameters0);
        Assertions.mustBeInAcceptingState(algorithmParameters0);

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

        byte[] plainText = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, secretKey, algorithmParameters0, secureRandom0);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest19() throws Exception {
        Certificate cert = loadCertificate();

        int plain_off = 0;
        byte[] plainText = "secret".getBytes();
        int len = 0;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] cipherText = cipher0.doFinal(plainText, plain_off, len);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest20() throws Exception {

        Certificate cert = loadCertificate();
        byte[] plainText = "secret".getBytes();
        byte[] cipherText = new byte[512];

        int plain_off = 0;
        int len = 0;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        cipher0.doFinal(plainText, plain_off, len, cipherText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }
}
