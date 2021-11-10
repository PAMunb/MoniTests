import org.junit.Test;

import javax.crypto.KeyGenerator;
import java.security.SecureRandom;

public class KeyGeneratorTest {

    @Test(expected = Test.None.class)
    public void safeExecutionWithoutSpecifiedProvider() throws Exception {
        SecureRandom random = new SecureRandom();
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(192);
        generator.generateKey();
    }

//    @Test(expected = Test.None.class)
//    public void validExecutionWithInstanceStrong() throws Exception {
//        SecureRandom random = SecureRandom.getInstanceStrong();
//        random.setSeed(123L);
//        random.nextInt(123);
//    }
//
//    @Test(expected = java.lang.RuntimeException.class)
//    public void invalidExecutionOrderWithInstanceStrong() throws Exception {
//        SecureRandom random = SecureRandom.getInstanceStrong();
//        random.nextInt(123);
//    }

}
