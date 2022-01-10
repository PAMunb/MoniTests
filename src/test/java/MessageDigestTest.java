import java.security.*;

import br.unb.cic.mop.jca.eh.ErrorCollector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

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
        Assertions.hasEnsuredPredicate(out);
        Assertions.mustBeInAcceptingState(md);
    }

    @Ignore
    public void unsafeAlgorithmWithCorrectCallSequenceDefaultDigest() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] msg = MESSAGE_STRING.getBytes();
        md.update(msg);
        byte[] out = md.digest();
        Assertions.hasNotEnsuredPredicate(out);
        Assertions.mustNotBeInAcceptingState(md);
    }

    @Ignore
    public void safeAlgorithmWithCorrectCallSequenceUpdatesPreInbyteDefaultDigest() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte pre_inbyte = 1;
        byte[] msg = MESSAGE_STRING.getBytes();
        md.update(pre_inbyte);
        byte[] out = md.digest();
        Assertions.hasEnsuredPredicate(out);
        Assertions.mustBeInAcceptingState(md);
    }

    @Ignore
    public void safeAlgorithmWithProviderCorrectCallSequenceUpdatesPreInByteDefaultDigest() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256", Security.getProvider("SUN"));
        byte pre_inbyte = 0;
        byte[] msg = MESSAGE_STRING.getBytes();
        md.update(pre_inbyte);
        byte[] out = md.digest();
        Assertions.hasEnsuredPredicate(out);
        Assertions.mustBeInAcceptingState(md);
    }

    /*
    The following test case causes our heuristics to crash, because, by the time md.digest(msg) is called, there is a
    match. If we __RESET the monitor on match, then the subsequent calls do not match the ERE, and we go into @fail.
    However, if we do not __RESET, we will cause interference between the tests. Also, taking a look at the JCA
    definition of the method, this CRySL might not be 100% accurate. Finally, maybe we want to validate empirically if
    this case happens at all.
     */
    @Test
    public void safeAlgorithmCorrectCallSequenceDigestsByteArrayBeforeUpdate() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] msg = MESSAGE_STRING.getBytes();
        byte[] out = md.digest(msg);
        md.update(msg);
        out = md.digest();
        Assertions.hasEnsuredPredicate(out);
        Assertions.mustBeInAcceptingState(md);
    }

    @Ignore
    public void unsafeAlgorithmMissingUpdateCallDefaultDigest() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        /*
        Missing calls will be left as comment in test cases
        byte[] msg = MESSAGE_STRING.getBytes();
        md.update(msg);
        */
        byte[] out = md.digest();
        Assertions.hasNotEnsuredPredicate(out);
        Assertions.mustNotBeInAcceptingState(md);
    }
//    @Test
//    public void missingUpdateCall() throws Exception {
//        MessageDigest md = MessageDigest.getInstance("SHA-1");
//        String Password = "secret";
//        byte[] msg = Password.getBytes();
//        byte[] aMessageDigest = md.digest();
//        Assertions.expectingNonEmptySetOfErrors(3);
//    }
//
//    @Test
//    public void messageDigestValidTest1() throws NoSuchAlgorithmException {
//        byte[] inbytearr = "secret".getBytes();
//        MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
//        byte[] out = messageDigest0.digest(inbytearr);
//        Assertions.hasNotEnsuredPredicate(out);
//        Assertions.mustNotBeInAcceptingState(messageDigest0);
//    }
}
