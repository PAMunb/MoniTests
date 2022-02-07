package br.unb.cic.mop.simple;

import br.unb.cic.mop.eh.ErrorCollector;
import org.junit.*;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CipherTest {

    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    Crypto2 crypto;

    @Test
    public void executeTest() throws Exception {
        CipherTest instance = new CipherTest();

        instance.go();
        Assert.assertTrue(ErrorCollector.instance().getErrors().size() > 0);
    }

    public void go() throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        crypto = new Crypto2("AES/ECB/PKCS5Padding");
        crypto.encrypt("abc","");
    }
}

class Crypto2 {
    Cipher cipher;
    String defaultAlgo;
    public Crypto2(String defAlgo) throws NoSuchPaddingException, NoSuchAlgorithmException {
        defaultAlgo = defAlgo;
    }

    public byte[] encrypt(String txt, String passedAlgo) throws UnsupportedEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException {
        if(passedAlgo.isEmpty()){
            passedAlgo = defaultAlgo;
        }

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance(defaultAlgo);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte [] txtBytes = txt.getBytes();
        return cipher.doFinal(txtBytes);
    }
}
