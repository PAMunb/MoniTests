import br.unb.cic.mop.jca.eh.ErrorCollector;

import br.unb.cic.mop.jca.util.ExecutionContext;
import br.unb.cic.mop.test.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class KeyGeneratorTest {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    @After
    public void tearDown() {
         ErrorCollector.instance().printErrors();
    }

    @Test
    public void safeAlgorithmWithoutSpecifiedProvider() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(192);
        SecretKey key = generator.generateKey();
        Assertions.expectingEmptySetOfErrors();
        Assertions.hasEnsuredPredicate(ExecutionContext.Property.GENERATED_KEY, key);
    }

    @Test
    public void unsafeAlgorithmWithoutSpecifiedProvider() throws Exception {
        SecureRandom random = new SecureRandom();
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        generator.init(56);
        generator.generateKey();
        Assertions.expectingNonEmptySetOfErrors();
    }

}