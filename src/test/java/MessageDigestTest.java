import java.security.*;

import br.unb.cic.mop.jca.eh.ErrorCollector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
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
    public void validExecution() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String Password = "secret";
        byte[] msg = Password.getBytes();
        md.update(msg);
        byte[] out = md.digest();
        //assertTrue(ErrorCollector.instance().getErrors().isEmpty());
        Assertions.hasEnsuredPredicate(out);
        Assertions.mustBeInFinalState(md);
    }

    @Test
    public void missingUpdateCall() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        String Password = "secret";
        byte[] msg = Password.getBytes();
        byte[] aMessageDigest = md.digest();
        assertEquals(3, ErrorCollector.instance().getErrors().size());
    }

//    @Test
//    public void messageDigestValidTest1() throws NoSuchAlgorithmException {
//        byte[] inbytearr = "secret".getBytes();
//        MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
//        byte[] out = messageDigest0.digest(inbytearr);
//        Assertions.hasNotEnsuredPredicate(out);
//        Assertions.mustNotBeInFinalState(messageDigest0);
//    }
}
