package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTBool implements ASTNode {
    boolean bool;
    
    public ASTBool(boolean bool) {
        this.bool = bool;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        return new VBool(bool);
    }
}
