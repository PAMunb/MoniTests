package br.unb.cic.mop.simple;

import br.unb.cic.mop.ExecutionContext;
import br.unb.cic.mop.bench02.predictablepbepassword.PredictablePBEPasswordBBCase1;
import br.unb.cic.mop.eh.ErrorCollector;
import br.unb.cic.mop.test.Assertions;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class RSPTest {

    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    @Test
    public void simpleTest1() throws Exception {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

        IntStream stream = random.ints();

        Assertions.hasEnsuredPredicate(ExecutionContext.Property.RANDOMIZED, stream);

        String password = String.valueOf(stream);

        char[] chars = password.toCharArray();
        Assertions.hasEnsuredPredicate(ExecutionContext.Property.RANDOMIZED, chars);
    }

    @Test
    public void simpleTest2() {
        PredictablePBEPasswordBBCase1 ckp = new PredictablePBEPasswordBBCase1();
        ckp.key();
        Assertions.assertTrue(ErrorCollector.instance().getErrors().size() > 0);
    }

    public void key() {
        String defaultKey = "saagar";
        byte [] salt = new byte[16];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(salt);
        int iterationCount = 11010;
        int keyLength = 16;
        PBEKeySpec pbeKeySpec = new PBEKeySpec(defaultKey.toCharArray(),salt,iterationCount,keyLength);
    }
}
