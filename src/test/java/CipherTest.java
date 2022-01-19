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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.*;
import java.security.cert.Certificate;
import java.security.spec.InvalidParameterSpecException;

public class CipherTest {
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

    private Key loadKey() throws Exception {
        File ksInputFile = new File(getClass().getClassLoader().getResource("testInput-ks").getFile());
        InputStream fileIn = new FileInputStream(ksInputFile);
        KeyStore keyStore0 = KeyStore.getInstance("JKS");
        keyStore0.load(fileIn, "password".toCharArray());
        return keyStore0.getKey("mop", "password".toCharArray());
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

    @Ignore // TODO: not able to fix this test case.
    public void cipherValidTest1() throws Exception {

        Certificate cert = loadCertificate();

        Key wrappedKey = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(Cipher.WRAP_MODE, cert);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore // TODO: not able to fix this test case.
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



    @Ignore // TODO: not able to fix this test case.
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

    @Test
    public void cipherValidTest4()
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        Key wrappedKey = KeyGenerator.getInstance("AES").generateKey();

        Cipher cipher0 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher0.init(Cipher.WRAP_MODE, secretKey);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest5()
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

        Key wrappedKey = KeyGenerator.getInstance("AES").generateKey();

        Cipher cipher0 = Cipher.getInstance("AES/CBC/PKCS5Padding");

        cipher0.init(Cipher.WRAP_MODE, secretKey, secureRandom0);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest6() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException,
            InvalidKeyException, InvalidAlgorithmParameterException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        int num = 2024;

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

        GCMParameterSpec gCMParameterSpec0 = new GCMParameterSpec(96, genSeed);
        Assertions.hasEnsuredPredicate(gCMParameterSpec0);
        Assertions.mustBeInAcceptingState(gCMParameterSpec0);

        Key wrappedKey = KeyGenerator.getInstance("AES").generateKey();

        Cipher cipher0 = Cipher.getInstance("AES/GCM/NoPadding");

        cipher0.init(Cipher.WRAP_MODE, secretKey, gCMParameterSpec0);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore //TODO: We could not fix this test case.
    public void cipherValidTest7() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException,
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

        Key wrappedKey = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, secretKey, algorithmParameters0);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest8() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException,
            InvalidKeyException, InvalidAlgorithmParameterException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        int num = 2024;

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

        GCMParameterSpec gCMParameterSpec0 = new GCMParameterSpec(96, genSeed);
        Assertions.hasEnsuredPredicate(gCMParameterSpec0);
        Assertions.mustBeInAcceptingState(gCMParameterSpec0);

        Key wrappedKey = KeyGenerator.getInstance("AES").generateKey();

        Cipher cipher0 = Cipher.getInstance("AES/GCM/NoPadding");
        cipher0.init(Cipher.WRAP_MODE, secretKey, gCMParameterSpec0, secureRandom0);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore //TODO: We could not fix this test case.
    public void cipherValidTest9() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException,
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

        Key wrappedKey = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, secretKey, algorithmParameters0, secureRandom0);
        byte[] wrappedKeyBytes = cipher0.wrap(wrappedKey);
        Assertions.hasEnsuredPredicate(wrappedKeyBytes);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest10() throws Exception {

        Certificate cert = loadCertificate();
        byte[] plainText = "secret".getBytes();

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest11() throws Exception {

        Certificate cert = loadCertificate();
        byte[] plainText = "secret".getBytes();

        Cipher cipher0 = Cipher.getInstance("RSA", "SunJCE");
        cipher0.init(1, cert);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest12() throws Exception {

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

        Certificate cert = loadCertificate();
        byte[] plainText = "secret".getBytes();

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert, secureRandom0);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
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

        int num = 2024;// 0 leads to an empty genSeed... so we changed it.

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

    @Test
    public void cipherValidTest21() throws Exception {

        Certificate cert = loadCertificate();

        byte[] cipherText = new byte[512];
        byte[] plainText = "secret".getBytes();

        int plain_off = 0;
        int len = 0;
        int ciphertext_off = 0;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        cipher0.doFinal(plainText, plain_off, len, cipherText, ciphertext_off);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore // TODO: For some reason, we could not specify the additional
            //   doFinal(ByteBuffer, ByteBuffer) event
    public void cipherValidTest22() throws Exception {

        Certificate cert = loadCertificate();

        ByteBuffer plainBuffer = ByteBuffer.allocate(20);
        ByteBuffer cipherBuffer = ByteBuffer.allocate(512);

        plainBuffer.put("secret".getBytes());

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        cipher0.doFinal(plainBuffer, cipherBuffer);
        Assertions.hasEnsuredPredicate(cipherBuffer);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest23() throws Exception {

        Certificate cert = loadCertificate();
        byte[] plainText =  "secret".getBytes();
        byte[] pre_plaintext = "pre-plaintext".getBytes();

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore // TODO: For some reason, we could not specify the additional
            //   getInstance(String, String) event
    public void cipherValidTest24() throws Exception {

        Certificate cert = loadCertificate();
        byte[] plainText =  "secret".getBytes();
        byte[] pre_plaintext = "pre-plaintext".getBytes();


        Cipher cipher0 = Cipher.getInstance("RSA", "SunJCE");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest25() throws Exception {

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

        Certificate cert = loadCertificate();
        byte[] plainText = "secret".getBytes();
        byte[] pre_plaintext = "pre-plain".getBytes();

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert, secureRandom0);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest26() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
            NoSuchAlgorithmException, InvalidKeyException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        byte[] plainText = "secret".getBytes();
        byte[] pre_plaintext = "pre-plain".getBytes();

        Cipher cipher0 = Cipher.getInstance("AES/GCM/NoPadding");
        cipher0.init(1, secretKey);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest27() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
            NoSuchAlgorithmException, InvalidKeyException {

        KeyGenerator keyGenerator0 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator0.generateKey();
        Assertions.hasEnsuredPredicate(secretKey);
        Assertions.mustBeInAcceptingState(keyGenerator0);

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

        byte[] plainText = "secret".getBytes();
        byte[] pre_plaintext = "pre-plain".getBytes();

        Cipher cipher0 = Cipher.getInstance("AES/GCM/NoPadding");
        cipher0.init(1, secretKey, secureRandom0);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest28() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
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
        byte[] pre_plaintext = "pre-plain".getBytes();

        Cipher cipher0 = Cipher.getInstance("AES/GCM/NoPadding");
        cipher0.init(1, secretKey, gCMParameterSpec0);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore // TODO: We could not fix this test case.
    public void cipherValidTest29()
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
        byte[] pre_plaintext = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, secretKey, algorithmParameters0);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest30() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
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
        byte[] pre_plaintext = "pre-plain".getBytes();

        Cipher cipher0 = Cipher.getInstance("AES/GCM/NoPadding");
        cipher0.init(1, secretKey, gCMParameterSpec0, secureRandom0);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore
    public void cipherValidTest31()
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
        byte[] pre_plaintext = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, secretKey, algorithmParameters0, secureRandom0);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest32() throws Exception {

        Certificate cert = loadCertificate();
        byte[] plainText = "secret".getBytes();
        byte[] pre_plaintext = "pre-plain".getBytes();
        int pre_plain_off = 0;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext, pre_plain_off, 0);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest33() throws Exception {

        Certificate cert = loadCertificate();
        int pre_len = 0;
        byte[] plainText = "secret".getBytes();
        byte[] pre_ciphertext = "pre-cipher-text".getBytes();
        byte[] pre_plaintext = "pre-plain-text".getBytes();
        int pre_plain_off = 0;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        cipher0.update(pre_plaintext, pre_plain_off, pre_len, pre_ciphertext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest34() throws Exception {

        int pre_ciphertext_off = 0;
        Certificate cert = loadCertificate();
        int pre_len = 0;
        byte[] plainText = "secret".getBytes();
        byte[] pre_ciphertext = "pre-cipher-text".getBytes();
        byte[] pre_plaintext = "pre-plain-text".getBytes();
        int pre_plain_off = 0;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        cipher0.update(pre_plaintext, pre_plain_off, pre_len, pre_ciphertext, pre_ciphertext_off);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest35() throws Exception {

        Certificate cert = loadCertificate();
        byte[] plainText = "secret".getBytes();
        ByteBuffer pre_plainBuffer = ByteBuffer.allocate(256);
        ByteBuffer pre_cipherBuffer = ByteBuffer.allocate(1024);

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        cipher0.update(pre_plainBuffer, pre_cipherBuffer);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest36() throws Exception {

        Certificate cert = loadCertificate();

        int plain_off = 0;
        int len = 0;

        byte[] plainText = "secret".getBytes();
        byte[] pre_plaintext = "pre-plain".getBytes();

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText, plain_off, len);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest37() throws Exception {

        Certificate cert = loadCertificate();

        int plain_off = 0;
        int len = 0;

        byte[] plainText = "secret".getBytes();
        byte[] pre_plaintext = "pre-plain".getBytes();
        byte[] cipherText = new byte[512];

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        cipher0.doFinal(plainText, plain_off, len, cipherText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest38() throws Exception {

        Certificate cert = loadCertificate();

        int plain_off = 0;
        int len = 0;
        int ciphertext_off = 0;

        byte[] plainText = "secret".getBytes();
        byte[] pre_plaintext = "pre-plain".getBytes();
        byte[] cipherText = new byte[512];


        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        cipher0.doFinal(plainText, plain_off, len, cipherText, ciphertext_off);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore // TODO: we do not have a doFinal(ByteBuffer, ByteBuffer)
    public void cipherValidTest39() throws Exception {

        Certificate cert = loadCertificate();

        ByteBuffer plainBuffer = ByteBuffer.allocate(256);
        ByteBuffer cipherBuffer = ByteBuffer.allocate(512);

        byte[] pre_plaintext = "secret".getBytes();

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        cipher0.doFinal(plainBuffer, cipherBuffer);
        Assertions.hasEnsuredPredicate(cipherBuffer);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherValidTest40() throws Exception {

        Certificate cert = loadCertificate();
        byte[] pre_plaintext = "pre-plain".getBytes();

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal();
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Ignore // TODO: we do not have a doFinal(byte[], int)
    public void cipherValidTest41() throws Exception {

        Certificate cert = loadCertificate();

        byte[] pre_plaintext = "pre-plain".getBytes();
        byte[] cipherText = new byte[512];

        int ciphertext_off = 0;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        cipher0.doFinal(cipherText, ciphertext_off);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherInvalidTest1() throws NoSuchPaddingException, NoSuchAlgorithmException {

        Cipher cipher0 = Cipher.getInstance("RSA");
        Assertions.mustNotBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherInvalidTest2() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {

        Cipher cipher0 = Cipher.getInstance("RSA", "SunJCE");
        Assertions.mustNotBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherInvalidTest3() throws Exception {

        Certificate cert = loadCertificate();

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        Assertions.mustNotBeInAcceptingState(cipher0);

    }

    @Test
    public void cipherInvalidTest4() throws Exception {

        Certificate cert = loadCertificate();

        Cipher cipher0 = Cipher.getInstance("RSA", "SunJCE");
        cipher0.init(1, cert);
        Assertions.mustNotBeInAcceptingState(cipher0);

    }
}
