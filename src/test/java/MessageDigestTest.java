import java.security.*;

import br.unb.cic.eh.ErrorCollector;
import br.unb.cic.eh.ErrorDescription;
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageDigestTest  {

    @Test
    public void validExecution() throws Exception {
        ErrorCollector.instance().reset();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String Password = "secret";
        byte[] msg = Password.getBytes();
        md.update(msg);
        byte[] aMessageDigest = md.digest();
        assertTrue(ErrorCollector.instance().getErrors().isEmpty());
    }

    @Test
    public void missingUpdateCall() throws Exception {
        ErrorCollector.instance().reset();
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        String Password = "secret";
        byte[] msg = Password.getBytes();
        byte[] aMessageDigest = md.digest();
        assertTrue(!ErrorCollector.instance().getErrors().isEmpty());
        for(ErrorDescription e: ErrorCollector.instance().getErrors()) {
            System.out.println(e);
        }
    }

}
