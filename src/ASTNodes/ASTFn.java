package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTFn implements ASTNode {
    String id;
    ASTNode body;

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        return new VClos(env, id, body);
    }
    
    ASTFn(String id, ASTNode body) {
        this.id = id;
        this.body = body;
    }

    public void setBody(String newId) {
        // Apply currying by wrapping the current body in a new ASTFn node
        this.body = new ASTFn(newId, this.body);
    }

}
