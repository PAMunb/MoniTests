import br.unb.cic.mop.jca.eh.ErrorCollector;

import br.unb.cic.mop.test.Assertions;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;

public class MacTest {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    @After
    public void tearDown() {
        ErrorCollector.instance().printErrors();
    }

    @Test
    public void macValidTest1() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Key key = KeyGenerator.getInstance("HmacSHA256").generateKey();;
        Mac mac0 = Mac.getInstance("HmacSHA256");
        mac0.init(key);
        byte[] output1 = mac0.doFinal();
        Assertions.hasEnsuredPredicate(output1);
        Assertions.mustBeInAcceptingState(mac0);
    }

    @Test
    public void macValidTest2()  throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        Key key = KeyGenerator.getInstance("HmacSHA256").generateKey();
        Mac mac0 = Mac.getInstance("HmacSHA256", "SunJCE");
        mac0.init(key);
        byte[] output1 = mac0.doFinal();
        Assertions.hasEnsuredPredicate(output1);
        Assertions.mustBeInAcceptingState(mac0);
    }

    //TODO: This test case is not valid, since
    //  it throws java.security.InvalidAlgorithmParameterException:
    //  HMAC does not use parameters
    @Ignore
    public void macValidTest3() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException,
            InvalidAlgorithmParameterException {

        int outputLength = 0;

        HMACParameterSpec hMACParameterSpec0 = new HMACParameterSpec(outputLength);
        Assertions.hasEnsuredPredicate(hMACParameterSpec0);
        Assertions.mustBeInAcceptingState(hMACParameterSpec0);

        Key key = KeyGenerator.getInstance("HmacSHA256").generateKey();;

        Mac mac0 = Mac.getInstance("HmacSHA256");
        mac0.init(key, hMACParameterSpec0);
        byte[] output1 = mac0.doFinal();
        Assertions.hasEnsuredPredicate(output1);
        Assertions.mustBeInAcceptingState(mac0);

    }

    @Test
    public void macValidTest4() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] input = "secret".getBytes(StandardCharsets.UTF_8);
        Key key = KeyGenerator.getInstance("HmacSHA256").generateKey();;
        Mac mac0 = Mac.getInstance("HmacSHA256");
        mac0.init(key);
        byte[] output2 = mac0.doFinal(input);
        Assertions.hasEnsuredPredicate(output2);
        Assertions.mustBeInAcceptingState(mac0);
    }

    @Ignore
    public void macValidTest5() throws IllegalStateException, BadPaddingException, NoSuchPaddingException,
            IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, ShortBufferException {

        Certificate cert = null;
        byte[] plainText = null;
        byte[] pre_plaintext = null;

        Cipher cipher0 = Cipher.getInstance("RSA");
        cipher0.init(1, cert);
        byte[] pre_ciphertext = cipher0.update(pre_plaintext);
        byte[] cipherText = cipher0.doFinal(plainText);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(cipher0);

        int outOffset = 0;
        Key key = null;

        Mac mac0 = Mac.getInstance("HmacSHA256");
        mac0.init(key);
        mac0.doFinal(cipherText, outOffset);
        Assertions.hasEnsuredPredicate(cipherText);
        Assertions.mustBeInAcceptingState(mac0);

    }

    @Test
    public void macValidTest6() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {

        byte inp = 0;
        Key key = KeyGenerator.getInstance("HmacSHA256").generateKey();;

        Mac mac0 = Mac.getInstance("HmacSHA256");
        mac0.init(key);
        mac0.update(inp);
        byte[] output1 = mac0.doFinal();
        Assertions.hasEnsuredPredicate(output1);
        Assertions.mustBeInAcceptingState(mac0);

    }

    @Test
    public void macValidTest7()
            throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {

        byte inp = 0;
        Key key = KeyGenerator.getInstance("HmacSHA256").generateKey();;

        Mac mac0 = Mac.getInstance("HmacSHA256", "SunJCE");
        mac0.init(key);
        mac0.update(inp);
        byte[] output1 = mac0.doFinal();
        Assertions.hasEnsuredPredicate(output1);
        Assertions.mustBeInAcceptingState(mac0);

    }

    //TODO: This test case is not valid, since
    //  it throws java.security.InvalidAlgorithmParameterException:
    //  HMAC does not use parameters
    @Ignore
    public void macValidTest8() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException,
            InvalidAlgorithmParameterException {

        int outputLength = 0;

        HMACParameterSpec hMACParameterSpec0 = new HMACParameterSpec(outputLength);
        Assertions.hasEnsuredPredicate(hMACParameterSpec0);
        Assertions.mustBeInAcceptingState(hMACParameterSpec0);

        byte inp = 0;
        Key key = null;

        Mac mac0 = Mac.getInstance("HmacMD5");
        mac0.init(key, hMACParameterSpec0);
        mac0.update(inp);
        byte[] output1 = mac0.doFinal();
        Assertions.hasEnsuredPredicate(output1);
        Assertions.mustBeInAcceptingState(mac0);

    }

    @Test
    public void macValidTest9() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {

        byte[] pre_input = "secret".getBytes();
        Key key = KeyGenerator.getInstance("HmacSHA256").generateKey();;

        Mac mac0 = Mac.getInstance("HmacSHA256");

        mac0.init(key);
        mac0.update(pre_input);
        byte[] output1 = mac0.doFinal();
        Assertions.hasEnsuredPredicate(output1);
        Assertions.mustBeInAcceptingState(mac0);

    }

    @Test
    public void macValidTest10() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {

        int offset = 0;
        int len = 0;
        byte[] pre_input = "secret".getBytes();
        Key key = KeyGenerator.getInstance("HmacSHA256").generateKey();;

        Mac mac0 = Mac.getInstance("HmacSHA256");

        mac0.init(key);
        mac0.update(pre_input, offset, len);
        byte[] output1 = mac0.doFinal();
        Assertions.hasEnsuredPredicate(output1);
        Assertions.mustBeInAcceptingState(mac0);

    }
}