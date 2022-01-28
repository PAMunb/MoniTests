package br.unb.cic.mop.drivers;

import br.unb.cic.mop.bench01.MacTest;
import br.unb.cic.mop.bench01.PBEParameterSpecTest;
import br.unb.cic.mop.eh.ErrorCollector;
import br.unb.cic.mop.bench01.CipherTest;
import br.unb.cic.mop.bench01.MessageDigestTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
        PBEParameterSpecTest.class,
})
public class Bench01 {

    @BeforeClass
    public static void beforeClass() throws Exception {
        ErrorCollector.instance().reset();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        ErrorCollector.instance().printErrors();
    }
}
