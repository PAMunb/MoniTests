package br.unb.cic.mop.eh.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import br.unb.cic.mop.eh.ErrorDescription;

@Deprecated
public class CSVLogger implements ILogger {

    public static final String HEADER = "spec,class,className,method,location,error";

    @Override
    public void logError(ErrorDescription err) {

        File outDir = new File("output");

        if(! outDir.exists()) {
            outDir.mkdir();
        }

        File logger = new File("output/summary.csv");

        boolean generateHeader = !logger.exists();

        try (PrintWriter pw = new PrintWriter(new FileWriter(logger, true))) {
            if(generateHeader) {
                pw.println(HEADER);
            }
            pw.println(err.getErrorSummary().toString());
        }
        catch(Exception e) {}
    }
}
