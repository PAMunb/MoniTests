import java.security.*;

import br.unb.cic.eh.ErrorCollector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageDigestTest  {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    @Test
    public void validExecution() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String Password = "secret";
        byte[] msg = Password.getBytes();
        md.update(msg);
        byte[] aMessageDigest = md.digest();
        assertTrue(ErrorCollector.instance().getErrors().isEmpty());
    }

    @Test
    public void missingUpdateCall() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        String Password = "secret";
        byte[] msg = Password.getBytes();
        byte[] aMessageDigest = md.digest();
        assertEquals(3, ErrorCollector.instance().getErrors().size());
    }
}
