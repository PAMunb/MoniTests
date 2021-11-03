import java.security.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageDigestTest  {

    @Test(expected = Test.None.class)
    public void validExecution() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String Password = "secret";
        byte[] msg = Password.getBytes();
        md.update(msg);
        byte[] aMessageDigest = md.digest();
    }

    @Test(expected = RuntimeException.class)
    public void missingUpdateCall() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        String Password = "secret";
        byte[] msg = Password.getBytes();
        byte[] aMessageDigest = md.digest();
    }

}
