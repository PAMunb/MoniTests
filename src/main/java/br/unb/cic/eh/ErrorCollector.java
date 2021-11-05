package br.unb.cic.eh;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {

    private static ErrorCollector instance;

    private List<ErrorDescription> errors;

    public static ErrorCollector instance() {
        if(instance == null) {
            instance = new ErrorCollector();
        }
        return instance;
    }

    private ErrorCollector() {
        errors = new ArrayList<>();
    }

    public void reset() {
        errors = new ArrayList<>();
    }

    public void addError(ErrorDescription err) {
        errors.add(err);
    }

    public List<ErrorDescription> getErrors() {
        return errors;
    }

    public void printErrors() {
        for(ErrorDescription e: getErrors()) {
            System.out.println(e);
        }
    }
}
