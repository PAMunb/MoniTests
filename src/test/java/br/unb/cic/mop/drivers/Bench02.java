package br.unb.cic.mop.drivers;

import br.unb.cic.mop.eh.ErrorCollector;
import com.google.common.reflect.ClassPath;
import org.junit.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Bench02 {

    public static final String BENCH02_PACKAGE = "br.unb.cic.mop.bench02";
    private PrintStream original, dummy = null;
    private Logger logger;
    @BeforeClass
    public static void setUp() {
        ErrorCollector.instance().reset();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ErrorCollector.instance().printErrors();
    }

    @Test
    public void executeBenchmark()  {
        setupStandardOutput();
        Set<Class<?>> classes = null;

        try {
            setupLogger();
            classes = findBench02Classes();
        }
        catch(IOException ex) {
            Assert.fail(ex.getMessage());
        }

        Assert.assertTrue(classes.size() > 0);

        int executions = 0;
        int errors = 0;

        for (Class<?> c : classes) {
            Method mainMethod = findMainMethod(c);

            try {
                if (mainMethod != null) {
                    switch (mainMethod.getParameterCount()) {
                        case 0:
                            mainMethod.invoke(null);
                            executions++;
                            break;
                        case 1:
                            mainMethod.invoke(null, (Object) null);
                            executions++;
                            break;
                        default:
                            logger.log(Level.WARNING, String.format("Error in class %s. Method main has %d",
                                    c.getName(), mainMethod.getParameterCount()));
                    }
                }
            } catch (IllegalArgumentException ex) {
                logger.log(Level.WARNING, "Error on method: " + mainMethod.toString());
                errors++;
            }
            catch (Exception ex) {
                logger.log(Level.WARNING, ex.getCause() + " " + ex.getMessage());
                errors++;
            }
        }

        Assert.assertTrue(executions > 0);

        logger.log(Level.WARNING, "number of executed methods : " + executions);
        logger.log(Level.WARNING, "number of executions with errors " + errors);

        restoreStandardOutput();
    }

    /* finds the classes of our second benchmark */
    private Set<Class<?>> findBench02Classes() throws IOException {
        ClassPath cp = ClassPath.from(getClass().getClassLoader());

        Set<Class<?>> classes = new HashSet<>();

        cp.getTopLevelClassesRecursive(BENCH02_PACKAGE).stream().forEach(ci -> classes.add(ci.load()));

        return classes;
    }

    /* finds the main method of a given class */
    private Method findMainMethod(Class<?> c) {
        Method mainMethod = null;
        Method[] methods = c.getDeclaredMethods();

        for(Method m: methods) {
            if(m.getName().equals("main")) {
                return m;
            }
        }
        return null;
    }

    /* We use the following method to "silence" the standard output stream */
    private void setupStandardOutput() {
        original = System.out;
        dummy = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                // do nothing ...
            }
        });
        System.setOut(dummy);
    }

    /* We use the following method to restore the standard output */
    private void restoreStandardOutput() {
        System.setOut(original);
    }

    private void setupLogger() throws IOException {
        FileHandler handler = new FileHandler("target/logger.txt", true);

        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.WARNING);

        logger = Logger.getLogger("");
        logger.setLevel(Level.WARNING);

        logger.addHandler(handler);
    }

}
