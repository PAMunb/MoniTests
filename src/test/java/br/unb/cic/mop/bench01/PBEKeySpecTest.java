package br.unb.cic.mop.bench01;

import br.unb.cic.mop.test.Assertions;
import org.junit.Test;

import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PBEKeySpecTest {

    @Test
    public void pBEKeySpecValidTest1() throws NoSuchAlgorithmException {

        int num = 256;

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

        int keylength = 64;
        char[] password = "secret".toCharArray();

        PBEKeySpec pBEKeySpec0 = new PBEKeySpec(password, genSeed, 13289, keylength);
        Assertions.hasEnsuredPredicate(pBEKeySpec0);
        pBEKeySpec0.clearPassword();
        Assertions.mustBeInAcceptingState(pBEKeySpec0);

    }

    @Test
    public void pBEKeySpecInvalidTest1() throws NoSuchAlgorithmException {

        int num = 256;

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

        int keylength = 64;
        char[] password = "secret".toCharArray();

        PBEKeySpec pBEKeySpec0 = new PBEKeySpec(password, genSeed, 13369, keylength);
        Assertions.hasEnsuredPredicate(pBEKeySpec0);
        Assertions.mustNotBeInAcceptingState(pBEKeySpec0);

    }
}