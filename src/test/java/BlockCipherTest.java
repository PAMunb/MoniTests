import br.unb.cic.mop.jca.eh.ErrorCollector;

import br.unb.cic.mop.jca.util.ExecutionContext;
import br.unb.cic.mop.test.Assertions;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class BlockCipherTest {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
        ExecutionContext.instance().reset();
    }

    @Test
    public void simpleTest() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(256);
        SecretKey key = keygen.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.update("secret".getBytes());
        cipherText = cipher.doFinal();
        Assertions.expectingEmptySetOfErrors();
    }

    @Test
    public void invalidTransformationTest() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(256);
        SecretKey key = keygen.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        cipher.update("secret".getBytes());
        cipher.doFinal();
        Assertions.expectingNonEmptySetOfErrors();
    }

    @Test
    public void invalidKeyTest() throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("DES");
        keygen.init(56);
        SecretKey key = keygen.generateKey();

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        cipher.update("secret".getBytes());
        cipher.doFinal();
        Assertions.expectingNonEmptySetOfErrors();
    }
}
