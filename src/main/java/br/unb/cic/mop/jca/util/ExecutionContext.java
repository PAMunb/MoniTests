package br.unb.cic.mop.jca.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class allows us to setup an execution
 * context, stating that an object is in an accepting
 * state or that an object has a property associated to it.
 *
 * We use it to "mimic" the ensures / requires
 * clauses of CrySL and to execute the unit
 * test cases.
 */
public class ExecutionContext {
    /*
     * The properties that we are interested in.
     */
    public enum Property {
        GENERATED_KEY,
        DIGESTED,
        GENERATE_SSL_CONTEXT,
        GENERATE_SSL_ENGINE,
        RANDOMIZED,
        GENERATED_KEY_MANAGERS,
        GENERATED_TRUST_MANAGER,
        GENERATED_TRUST_MANAGERS,
        GENERATED_KEY_STORE
    }

    private Map<Property, Object> context;

    private Set<Object> acceptingState;

    private static ExecutionContext instance;

    /*
     * A private constructor according to the
     * Singleton design pattern.
     */
    private ExecutionContext() {
        context = new HashMap<>();
        acceptingState = new HashSet<>();
    }

    /**
     * The unique way to obtain an instance to the
     * Execution context.
     *
     * @return the singleton ExecutionContext instance.
     */
    public static ExecutionContext instance() {
        if(instance == null) {
            instance = new ExecutionContext();
        }
        return instance;
    }

    /**
     * Remove a property from the ExecutionContext. We will
     * typically call this method in a <code>@fail</code>
     * clause of an MOP specification.
     */
    public void remove(Property property) {
        if(context.containsKey(property)) {
            context.remove(property);
        }
    }

    /**
     * We should call this method in the advice bodies,
     * whenever we want to ensure that an object satisfies
     * a given property.
     *
     * Take a look at the ensures clause of a CrySL rule,
     * which often ensures a property of an object (after
     * a call to a method).
     *
     * @param property property we want to relate to an object
     * @param value object that will have a property assigned to
     */
    public void setProperty(Property property, Object value) {
        context.put(property, value);
    }

    /**
     * Returns true if the object <code>obj</code> has
     * been assigned to the <code>property</code>.
     *
     * @return A boolean indicating if a mapping between
     * a property and a value exists.
     */
    public boolean validate(Property property, Object obj) {
        return context.containsKey(property) && context.get(property).equals(obj);
    }

    /**
     * Returns true if <code>obj</code> is in accepting state.
     */
    public boolean isInAcceptingState(Object obj) {
        return acceptingState.contains(obj);
    }

    /**
     * Setup that <code>obj</code> is in an accepting state.
     * We should call this method in a <code>@match</code>
     * clause o an MOP specification.
     */
    public void setObjectAsInAcceptingState(Object obj) {
        acceptingState.add(obj);
    }

    /**
     * Use this method to indicate that an <code>obj</code>
     * is not in accepting state anymore. We should call
     * this method in a <code>@fail</code> clause of an MOP
     * specification.
     */
    public void unsetObjectAsInAcceptingState(Object obj) { acceptingState.remove(obj); }

    /**
     * Checks if <code>obj</code> has a property related
     * to it (not mattering which one).

     * @return <code>true</code> if <code>obj</code> has a
     * property related to it.
     */
    public boolean hasEnsuredPredicate(Object obj) {
        return context.values().contains(obj);
    }

    /**
     * Reset the ExecutionContext to its initial state.
     */
    public void reset() {
        acceptingState.clear();
        context.clear();
    }
}
