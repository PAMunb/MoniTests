package br.unb.cic.mop.drivers;

import br.unb.cic.mop.eh.ErrorCollector;
import br.unb.cic.mop.bench01.CipherTest;
import br.unb.cic.mop.bench01.MessageDigestTest;
import br.unb.cic.mop.eh.report.STDOutputReport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CipherTest.class,
        MessageDigestTest.class
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
