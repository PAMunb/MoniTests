import br.unb.cic.mop.jca.eh.ErrorCollector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.security.SecureRandom;

public class SecureRandomTest {
    @Before
    public void setUp() {
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
        assertTrue(ErrorCollector.instance().getErrors().isEmpty());
    }

    @Test
    public void validExecutionWithInstanceStrong() throws Exception {
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.setSeed(123L);
        random.nextInt(123);
        assertTrue(ErrorCollector.instance().getErrors().isEmpty());
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
        assertTrue(ErrorCollector.instance().getErrors().isEmpty());
    }

    @Test
    public void validExecutionWithDefaultConstructorNextIntWithoutParameter() throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] seed = "password".getBytes();
        random.setSeed(seed);
        random.nextInt();
        random.nextInt(); //TODO: This test case should not lead to an error. We have to review the specs.
        assertTrue(!ErrorCollector.instance().getErrors().isEmpty());
    }

    @Test
    public void invalidExecutionOrderWithInstanceStrong() throws Exception {
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.nextInt(123);
        assertTrue(!ErrorCollector.instance().getErrors().isEmpty());
    }

}