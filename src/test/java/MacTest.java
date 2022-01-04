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
    public void macTest() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA512"); // Use a secure underlying hash for HMAC algorithm.
        keygen.init(256); // Explicitly initializing keyGenerator. Specify key size, and trust the provider supplied randomness.
        SecretKey hmacKey = keygen.generateKey(); // SecretKey holds Symmetric Key(K)
        Mac m = Mac.getInstance("HmacSHA256");
        m.init(new SecretKeySpec(hmacKey.getEncoded(), "HmacSHA512"));
        m.update("message".getBytes());
        byte[] senderMac = m.doFinal();
        Assertions.expectingEmptySetOfErrors();
    }

    @Test
    public void unsafeAlgorithm() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA1"); // Use a secure underlying hash for HMAC algorithm.
        keygen.init(256); // Explicitly initializing keyGenerator. Specify key size, and trust the provider supplied randomness.
        SecretKey hmacKey = keygen.generateKey(); // SecretKey holds Symmetric Key(K)
        Mac m = Mac.getInstance("HmacSHA1");
        m.init(new SecretKeySpec(hmacKey.getEncoded(), "HmacSHA512"));
        m.update("message".getBytes());
        byte[] senderMac = m.doFinal();
        Assertions.expectingNonEmptySetOfErrors();
    }

}