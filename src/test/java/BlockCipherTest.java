import br.unb.cic.mop.jca.eh.ErrorCollector;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class BlockCipherTest {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    @Test
    public void simpleTest() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(256);
        SecretKey key = keygen.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.update("secret".getBytes());
        assertTrue(ErrorCollector.instance().getErrors().isEmpty());
    }
}
