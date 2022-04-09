package br.unb.cic.mop.simple;

import br.unb.cic.mop.test.Assertions;
import org.junit.Test;


import javax.crypto.spec.PBEParameterSpec;

public class StaticSaltsBBCase1Test {
    @Test
    public void test(){
        key2();
    }

    public void key2(){
        PBEParameterSpec pbeParamSpec = null;
        byte[] salt = {(byte) 0xa2};
        int count = 1020;
        pbeParamSpec = new PBEParameterSpec(salt, count);
        Assertions.expectingNonEmptySetOfErrors();
    }
}
