package Env;

import java.util.*;
import Error.*;

public class Environment<E> {
    Environment<E> anc;
    Map<String, E> bindings;

    public Environment() {
        anc = null;
        bindings = new HashMap<String, E>();
    }

    public Environment(Environment<E> ancestor) {
        anc = ancestor;
        bindings = new HashMap<String, E>();
    }

    public Environment<E> beginScope() {
        return new Environment<E>(this);
    }

    public Environment<E> endScope() {
        return anc;
    }

    public void assoc(String id, E bind) throws InterpreterError {
        if (bindings.containsKey(id)) {
            throw new InterpreterError("The variable " + id + " already exists in this scope");
        }
        bindings.put(id, bind);
    }

    public E find(String id) throws InterpreterError {
        if (bindings.containsKey(id)) {
            if (bindings.containsKey(id)) {
                return bindings.get(id);
            } else {
                if (anc != null) {
                    return anc.find(id);
                } else {
                    throw new InterpreterError("The variable " + id + " was not declared in any scope");
                }
            }
        }
    }
}
