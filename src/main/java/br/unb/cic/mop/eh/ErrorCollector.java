package br.unb.cic.mop.eh;


import br.unb.cic.mop.eh.report.DefaultReport;
import br.unb.cic.mop.eh.report.IErrorReport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A singleton class for collecting errors while running
 * the monitoring process.
 */
public class ErrorCollector {

    private static ErrorCollector instance;

    private Set<ErrorDescription> errors;

    private IErrorReport report;

    public static ErrorCollector instance() {
        if(instance == null) {
            instance = new ErrorCollector();
        }
        return instance;
    }

    private ErrorCollector() {
        report = new DefaultReport();
        errors = new HashSet<>();
    }

    public void reset() {
        errors = new HashSet<>();
    }

    public void addError(ErrorDescription err) {
        errors.add(err);
        try {
            report.exportError(err);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    public Set<ErrorDescription> getErrors() {
        return errors;
    }

    public void setReport(IErrorReport report) {
        this.report = report;
    }

    public void printErrors() throws Exception {
        report.exportErrors(errors);
    }


}
