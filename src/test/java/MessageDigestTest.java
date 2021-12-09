import java.security.*;

import br.unb.cic.mop.jca.eh.ErrorCollector;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import br.unb.cic.mop.test.Assertions;

public class MessageDigestTest  {
    public final String MESSAGE_STRING = "Secret_String_To_Be_Hashed";
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    @After
    public void tearDown() {
        ErrorCollector.instance().printErrors();
    }

    @Test
    public void safeAlgorithmWithCorrectCallSequenceDefaultDigest() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] msg = MESSAGE_STRING.getBytes();
        md.update(msg);
        byte[] out = md.digest();
//        Assertions.hasEnsuredPredicate(out);
//        Assertions.mustBeInFinalState(md);
    }

    @Test
    public void unsafeAlgorithmWithCorrectCallSequenceDefaultDigest() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] msg = MESSAGE_STRING.getBytes();
        md.update(msg);
        byte[] out = md.digest();
//        Assertions.hasNotEnsuredPredicate(out);
//        Assertions.mustNotBeInFinalState(md);
    }

    @Test
    public void unsafeAlgorithmMissingUpdateCallDefaultDigest() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        /*
        Missing calls will be left as comment in test cases
        byte[] msg = MESSAGE_STRING.getBytes();
        md.update(msg);
        */
        byte[] out = md.digest();
//        Assertions.hasNotEnsuredPredicate(out);
//        Assertions.mustNotBeInFinalState(md);
    }

    @Test
    public void safeAlgorithmMissingUpdateCallByteArrayDigest() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] inbytearr = MESSAGE_STRING.getBytes();
        byte[] out = md.digest(inbytearr);
//        Assertions.hasNotEnsuredPredicate(out);
//        Assertions.mustNotBeInFinalState(md);
    }
}
