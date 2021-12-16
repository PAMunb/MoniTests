import br.unb.cic.mop.jca.util.ExecutionContext;
import br.unb.cic.mop.test.Assertions;

import org.junit.Test;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SSLContextTest {

    @Test
    public void sSLContextValidTest1() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] tms = null;
        KeyManager[] kms = null;

        SSLContext sSLContext0 = SSLContext.getInstance("TLSv1.2");
        sSLContext0.init(kms, tms, (SecureRandom) null);
        Assertions.hasEnsuredPredicate(sSLContext0);
    }

    @Test
    public void sSLContextUnsafeProtocol() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] tms = null;
        KeyManager[] kms = null;

        SSLContext sSLContext0 = SSLContext.getInstance("SSL");
        sSLContext0.init(kms, tms, (SecureRandom) null);
        Assertions.hasNotEnsuredPredicate(sSLContext0);
    }

}
