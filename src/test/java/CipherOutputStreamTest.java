import br.unb.cic.mop.jca.eh.ErrorCollector;
import br.unb.cic.mop.test.Assertions;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.io.ByteArrayOutputStream;
import java.security.Key;

import static org.junit.Assert.*;
public class CipherOutputStreamTest {
    @Test
    public void validSequence() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        Key k = keygen.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, k);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);

        byte[] arr = new byte[100];
        cipherOutputStream.write(arr);
        cipherOutputStream.flush();
        cipherOutputStream.close();

        Assertions.expectingNonEmptySetOfErrors();
    }
}
