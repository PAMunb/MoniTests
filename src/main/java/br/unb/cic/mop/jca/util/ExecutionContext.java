package br.unb.cic.mop.jca.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This class allows us to implement
 * dependencies between MOP specifications.
 * We use it to "mimic" the ensures / requires
 * clauses of CrySL.
 */
public class ExecutionContext {
    public enum Property {
        GENERATED_KEY
    }

    private Map<Property, Object> context;

    private static ExecutionContext instance;
    private ExecutionContext() {
        context = new HashMap<>();
    }

    public static ExecutionContext getInstance() {
        if(instance == null) {
            instance = new ExecutionContext();
        }
        return instance;
    }

    public void remove(Property property) {
        if(context.containsKey(property)) {
            context.remove(property);
        }
    }

    public void setProperty(Property property, Object value) {
        context.put(property, value);
    }

    public boolean validate(Property property, Object value) {
        return context.containsKey(property) && context.get(property).equals(value);
    }
}
