import org.junit.Test;

import java.security.SecureRandom;

public class SecureRandomTest {

    @Test(expected = Test.None.class)
    public void validExecutionWithNativePRNG() throws Exception {
        SecureRandom random = SecureRandom.getInstance("NativePRNG");
        random.setSeed(123L);
        random.nextInt(123);
    }

    @Test(expected = Test.None.class)
    public void validExecutionWithInstanceStrong() throws Exception {
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.setSeed(123L);
        random.nextInt(123);
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void invalidExecutionOrderWithInstanceStrong() throws Exception {
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.nextInt(123);
    }

}
