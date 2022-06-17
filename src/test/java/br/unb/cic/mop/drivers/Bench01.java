package br.unb.cic.mop.drivers;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.unb.cic.mop.eh.ErrorCollector;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({
//    CipherTest.class,
//    IvParameterSpecTest.class,
//    MessageDigestTest.class,
//    PBEKeySpecTest.class,
//    PBEParameterSpecTest.class})
public class Bench01 {

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.err.println("beforeClass .........................");
        ErrorCollector.instance().reset();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.err.println("afterClass .........................");
        ErrorCollector.instance().printErrors();
    }

}
