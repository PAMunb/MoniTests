package br.unb.cic.mop.simple;

import br.unb.cic.mop.eh.ErrorCollector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDTest {
    @Before
    public void setUp() {
        ErrorCollector.instance().reset();
    }

    @After
    public void tearDown() {
        System.out.println(ErrorCollector.instance().getErrors().size());
        ErrorCollector.instance().getErrors().stream().forEach(System.out::println);
    }

    @Test
    public void BrokenHashBBCase2() throws NoSuchAlgorithmException {
        String name = "abcdef";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(name.getBytes());
        System.out.println(md.digest());
    }
}
