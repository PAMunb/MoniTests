package br.unb.cic.mop.eh.report;

import br.unb.cic.mop.eh.ErrorDescription;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This report exports the list of errors to a CSV
 * file. This is a short representation of the erros.
 * And a given type of error appears only once in a given
 * method.
 */
public class DefaultReport implements IErrorReport {

    public static final String HEADER = "spec,error,class,method";

    class Summary {
        String spec;
        String error;
        String className;
        String methodName;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Summary summary = (Summary) o;
            return Objects.equals(spec, summary.spec) && Objects.equals(error, summary.error) && Objects.equals(className, summary.className) && Objects.equals(methodName, summary.methodName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(spec, error, className, methodName);
        }

        @Override
        public String toString() {
            return String.format("%s,%s,%s,%s", spec, error, className, methodName);
        }
    }

    @Override
    public void exportErrors(Set<ErrorDescription> errors) throws Exception {
        Set<Summary> summary = new HashSet<>();

        for(ErrorDescription err: errors) {
            Summary s = new Summary();
            s.spec = err.getSpec();
            s.error = err.getType().toString();

            Pattern pattern = Pattern.compile("([\\w+\\.]+)[.](\\w+)\\(.+\\)");
            Matcher matcher = pattern.matcher(err.getLocation());

            s.className = err.getLocation();
            s.methodName = err.getLocation();

            if(matcher.matches()) {
                s.className = matcher.group(1);
                s.methodName = matcher.group(2);
            }
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
