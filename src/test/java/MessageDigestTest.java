import java.security.*;
import java.io.*;
import org.junit.Test;

public class MessageDigestTest  {
    @Test
    public void validExecution() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        String Password = "secret";
        byte[] msg = Password.getBytes();
	//        md.update(msg);
        byte[] aMessageDigest = md.digest();        
    }

}
