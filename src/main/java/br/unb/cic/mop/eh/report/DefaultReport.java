package br.unb.cic.mop.eh.report;

import br.unb.cic.mop.eh.ErrorDescription;
import br.unb.cic.mop.eh.ErrorSummary;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * This report exports the list of errors to a CSV
 * file. This is a short representation of the erros.
 * And a given type of error appears only once in a given
 * method.
 */
public class DefaultReport implements IErrorReport {

    public static final String HEADER = "spec,error,class,method";

    @Override
    public void exportErrors(Set<ErrorDescription> errors) throws Exception {
        Set<ErrorSummary> summary = new HashSet<>();

        for(ErrorDescription err: errors) {
            ErrorSummary s = err.getErrorSummary();
            summary.add(s);
        }

        File outDir = new File("output");

        if(! outDir.exists()) {
            outDir.mkdir();
        }

        File csvOutputFile = new File(generateFileName());

        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println(HEADER);
            summary.stream().forEach(pw::println);
        }
    }


    private String generateFileName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();

        return "output/report-" + dtf.format(now) + ".csv";
    }
}
