import java.security.*;

import br.unb.cic.mop.jca.eh.ErrorCollector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unb.cic.mop.test.Assertions;

public class MessageDigestTest  {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    @After
    public void tearDown() {
        ErrorCollector.instance().printErrors();
    }

    @Test
    public void messageDigestValidTest1() throws NoSuchAlgorithmException {

        byte[] inbytearr = "secret".getBytes();

        MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
        byte[] out = messageDigest0.digest(inbytearr);
        Assertions.hasEnsuredPredicate(out);
        Assertions.mustBeInAcceptingState(messageDigest0);

    }

    @Test
    public void messageDigestValidTest2() throws NoSuchAlgorithmException, NoSuchProviderException {

        byte[] inbytearr = "secret".getBytes();

        MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256", "SUN");
        byte[] out = messageDigest0.digest(inbytearr);
        Assertions.hasEnsuredPredicate(out);
        Assertions.mustBeInAcceptingState(messageDigest0);

    }

    @Test
    public void messageDigestValidTest3() throws NoSuchAlgorithmException {

        byte[] inbytearr = "secret".getBytes();
        byte pre_inbyte = 0;

        MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
        byte[] out = messageDigest0.digest(inbytearr);
        messageDigest0.update(pre_inbyte);
        out = messageDigest0.digest();
        Assertions.hasEnsuredPredicate(out);
        Assertions.mustBeInAcceptingState(messageDigest0);

    }
}
