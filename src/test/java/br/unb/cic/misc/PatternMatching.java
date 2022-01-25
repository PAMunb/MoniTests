package br.unb.cic.misc;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

    @Test
    public void testFindClassName() {
        String location = "br.unb.cic.mop.bench02.brokenhash.BrokenHashABICase8.go(BrokenHashABICase8.java:25)";
        Pattern pattern = Pattern.compile("([\\w+\\.]+)[.]([a-zA-Z]+)\\(.+\\)");
        Matcher matcher = pattern.matcher(location);
        Assert.assertTrue(matcher.matches());

        Assert.assertEquals("br.unb.cic.mop.bench02.brokenhash.BrokenHashABICase8", matcher.group(1));
    }

    @Test
    public void testFindMethod() {
        String location = "br.unb.cic.mop.bench02.brokenhash.BrokenHashABICase8.go(BrokenHashABICase8.java:25)";
        Pattern pattern = Pattern.compile("([\\w+\\.]+)[.]([a-zA-Z]+)\\(.+\\)");
        Matcher matcher = pattern.matcher(location);
        Assert.assertTrue(matcher.matches());

        Assert.assertEquals("go", matcher.group(2));
    }
}
