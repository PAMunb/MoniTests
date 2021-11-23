package br.unb.cic.mop.test;

import br.unb.cic.mop.jca.util.ExecutionContext;

import org.junit.Assert;

public class Assertions extends Assert {

    public static void mustBeInFinalState(Object obj) {
        if(ExecutionContext.instance().isInAcceptingState(obj)) {
            assertTrue(true);
        }
        else {
            fail("Object is not in a final state.");
        }
    }

    public static void mustNotBeInFinalState(Object obj) {
        if(ExecutionContext.instance().isInAcceptingState(obj)) {
            fail("Object is in a final state.");
        }
        else {
            assertTrue(true);
        }
    }

    public static void hasEnsuredPredicate(Object obj) {
        if(ExecutionContext.instance().hasEnsuredPredicate(obj)) {
            assertTrue(true);
        }
        else {
            fail("Object has not ensured predicate.");
        }
    }

    public static void hasNotEnsuredPredicate(Object obj) {
        if(ExecutionContext.instance().hasEnsuredPredicate(obj)) {
            fail("Object has an ensured predicate.");
        }
        else {
            assertTrue(true);
        }
    }

    public static void hasEnsuredPredicate(ExecutionContext.Property property, Object obj) {
        if(ExecutionContext.instance().validate(property, obj)) {
            assertTrue(true);
        }
        else {
            fail("Object has not an ensured predicate of " + property);
        }
    }

}
