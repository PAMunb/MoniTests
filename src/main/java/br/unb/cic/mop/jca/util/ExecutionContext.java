package br.unb.cic.mop.jca.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class allows us to implement
 * dependencies between MOP specifications.
 * We use it to "mimic" the ensures / requires
 * clauses of CrySL.
 */
public class ExecutionContext {
    public enum Property {
        GENERATED_KEY, DIGESTED, GENERATE_SSL_CONTEXT, GENERATE_SSL_ENGINE
    }

    private Map<Property, Object> context;

    private Set<Object> acceptingState;

    private static ExecutionContext instance;

    private ExecutionContext() {
        context = new HashMap<>();
        acceptingState = new HashSet<>();
    }

    public static ExecutionContext instance() {
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

    public boolean isInAcceptingState(Object obj) {
        return acceptingState.contains(obj);
    }

    public void setObjectAsInAcceptingState(Object obj) {
        acceptingState.add(obj);
    }

    public void unsetObjectAsInAcceptingState(Object obj) { acceptingState.remove(obj); }

    public boolean hasEnsuredPredicate(Object obj) {
        return context.values().contains(obj);
    }

    public void reset() {
        acceptingState.clear();
        context.clear();
    }
}
