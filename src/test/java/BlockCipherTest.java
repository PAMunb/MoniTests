import br.unb.cic.mop.jca.eh.ErrorCollector;

import br.unb.cic.mop.jca.util.ExecutionContext;
import br.unb.cic.mop.test.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.crypto.*;
import java.security.*;
import java.security.cert.Certificate;

public class BlockCipherTest {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
        ExecutionContext.instance().reset();
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
}
