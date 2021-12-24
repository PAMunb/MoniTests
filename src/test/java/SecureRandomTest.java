import br.unb.cic.mop.jca.eh.ErrorCollector;
import br.unb.cic.mop.jca.util.ExecutionContext;
import br.unb.cic.mop.test.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;

public class SecureRandomTest {
    @Before
    public void setUp() {
        ExecutionContext.instance().reset();
        ErrorCollector.instance().reset();
    }

    @After
    public void tearDown() {
        // ErrorCollector.instance().printErrors();
    }

    @Test
    public void validExecutionWithNativePRNG() throws Exception {
        SecureRandom random = SecureRandom.getInstance("NativePRNG");
        random.setSeed(123L);
        random.nextInt(123);
        Assertions.expectingEmptySetOfErrors();
    }

    @Test
    public void validExecutionWithInstanceStrong() throws Exception {
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.setSeed(123L);
        random.nextInt(123);
        Assertions.expectingEmptySetOfErrors();
    }

    @Test
    public void validExecutionWithNativePRNGBlocking() throws Exception {
        SecureRandom random = SecureRandom.getInstance("NativePRNGBlocking");
        byte[] seed = "password".getBytes();
        random.setSeed(seed);
        random.nextInt(123);
        assertTrue(ErrorCollector.instance().getErrors().isEmpty());
    }

    @Test
    public void validExecutionWithNativePRNGBlockingNextIntWithoutParameter() throws Exception {
        SecureRandom random = SecureRandom.getInstance("NativePRNGBlocking");
        byte[] seed = "password".getBytes();
        random.setSeed(seed);
        random.nextInt();
        random.nextInt();
        Assertions.expectingEmptySetOfErrors();
    }

    @Test
    public void validExecutionWithDefaultConstructorNextIntWithoutParameter() throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] seed = "password".getBytes();
        random.setSeed(seed);
        random.nextInt();
        random.nextInt();
        Assertions.expectingEmptySetOfErrors();
    }

    @Test
    public void secureRandomValidTest1() throws NoSuchAlgorithmException {
        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);
    }

    @Ignore
    public void secureRandomValidTest2() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG", (Provider) null);
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);
    }

    @Test
    public void secureRandomValidTest3() throws NoSuchAlgorithmException {
        SecureRandom secureRandom0 = SecureRandom.getInstanceStrong();
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);
    }

    @Test
    public void secureRandomValidTest4() {
        SecureRandom secureRandom0 = new SecureRandom();
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);
    }

    @Test
    public void secureRandomValidTest5() throws NoSuchAlgorithmException {

        int num = 0;

        SecureRandom secureRandom1 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom1.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom1);

        SecureRandom secureRandom0 = new SecureRandom(genSeed);
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Test
    public void secureRandomValidTest6() throws NoSuchAlgorithmException {

        int num = 0;

        SecureRandom secureRandom1 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom1.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom1);

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        secureRandom0.setSeed(genSeed);
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Ignore
    public void secureRandomValidTest7() throws NoSuchAlgorithmException, NoSuchProviderException {

        int num = 0;

        SecureRandom secureRandom1 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom1.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom1);

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG", (Provider) null);
        secureRandom0.setSeed(genSeed);
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Test
    public void secureRandomValidTest8() throws NoSuchAlgorithmException {

        int num = 0;

        SecureRandom secureRandom1 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom1.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom1);

        SecureRandom secureRandom0 = SecureRandom.getInstanceStrong();
        secureRandom0.setSeed(genSeed);
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Test
    public void secureRandomValidTest9() throws NoSuchAlgorithmException {

        int num = 0;

        SecureRandom secureRandom1 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom1.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom1);

        SecureRandom secureRandom0 = new SecureRandom();
        secureRandom0.setSeed(genSeed);
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Test
    public void secureRandomValidTest10() throws NoSuchAlgorithmException {

        int num = 0;

        SecureRandom secureRandom1 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom1.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom1);

        SecureRandom secureRandom0 = new SecureRandom(genSeed);
        secureRandom0.setSeed(genSeed);
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Test
    public void secureRandomValidTest11() throws NoSuchAlgorithmException {

        long lSeed = 0;

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        secureRandom0.setSeed(lSeed);
        Assertions.hasEnsuredPredicate(secureRandom0);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Test
    public void secureRandomValidTest12() throws NoSuchAlgorithmException {

        int num = 0;

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Ignore
    public void secureRandomValidTest13() throws NoSuchAlgorithmException, NoSuchProviderException {

        int num = 0;

        SecureRandom secureRandom0 = SecureRandom.getInstance("SHA1PRNG", (Provider) null);
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

    @Test
    public void secureRandomValidTest14() throws NoSuchAlgorithmException {

        int num = 0;

        SecureRandom secureRandom0 = SecureRandom.getInstanceStrong();
        byte[] genSeed = secureRandom0.generateSeed(num);
        Assertions.hasEnsuredPredicate(genSeed);
        Assertions.mustBeInAcceptingState(secureRandom0);

    }

}
