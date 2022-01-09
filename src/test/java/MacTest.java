import br.unb.cic.mop.jca.eh.ErrorCollector;

import br.unb.cic.mop.test.Assertions;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.Mac;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;

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
}