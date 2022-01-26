package br.unb.cic.mop.simple;

import br.unb.cic.mop.bench02.brokencrypto.BrokenCryptoBBCase1;
import br.unb.cic.mop.eh.ErrorCollector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CipherTest {

    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    public void go() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    @Test
    public void brokenCryptoBBCase1() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        BrokenCryptoBBCase1 bc = new BrokenCryptoBBCase1();
        bc.go();
        Assert.assertEquals(6, ErrorCollector.instance().getErrors().size());
    }
}
