package br.unb.cic.mop.eh;


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

    public static ErrorCollector instance() {
        if(instance == null) {
            instance = new ErrorCollector();
        }
        return instance;
    }

    private ErrorCollector() {
        errors = new HashSet<>();
    }

    public void reset() {
        errors = new HashSet<>();
    }

    public void addError(ErrorDescription err) {
        errors.add(err);
    }

    public Set<ErrorDescription> getErrors() {
        return errors;
    }

    public void printErrors() {
        for(ErrorDescription e: getErrors()) {
            System.out.println(e);
        }
    }
}
