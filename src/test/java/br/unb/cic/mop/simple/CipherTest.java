package br.unb.cic.mop.simple;

import br.unb.cic.mop.bench02.brokencrypto.BrokenCryptoBBCase1;
import br.unb.cic.mop.bench02.insecureasymmetriccrypto.InsecureAsymmetricCipherBBCase1;
import br.unb.cic.mop.eh.ErrorCollector;
import org.junit.*;

import javax.crypto.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class CipherTest {

    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    public void go() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
        KeyPairGenerator kgp = KeyPairGenerator.getInstance("RSA");
        int keysize = 1024;
        kgp.initialize(keysize);
        KeyPair kp = kgp.generateKeyPair();


        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, kp.getPublic());

        //encrypting
        String myMessage = new String("Secret Message");
        SealedObject encryptedMessage = new SealedObject(myMessage,cipher);

        //decrypting
        Cipher dec = Cipher.getInstance("RSA");
        dec.init(Cipher.DECRYPT_MODE, kp.getPrivate());

        String message = (String) encryptedMessage.getObject(dec);
        System.out.println(message);
    }

    @Test
    public void fooTest() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
        InsecureAsymmetricCipherBBCase1 bc = new InsecureAsymmetricCipherBBCase1();
        bc.go();
    }
}
