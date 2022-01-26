package br.unb.cic.mop.eh.report;

import br.unb.cic.mop.eh.ErrorDescription;

import java.util.Set;

public class STDOutputReport implements IErrorReport {
    @Override
    public void exportErrors(Set<ErrorDescription> errors) throws Exception {
        errors.stream().forEach(System.out::println);
    }
}
