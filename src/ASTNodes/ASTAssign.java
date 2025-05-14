package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTAssign implements ASTNode {
    ASTNode name;
    ASTNode exp;

    public ASTAssign(ASTNode name, ASTNode exp) {
        this.name = name;
        this.exp = exp;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v1 = name.eval(e);
        if( v1 instanceof VCell) {
            IValue v2 = exp.eval(e);
            ((VCell)v1).setValue(v2);
            return v2;
        } else {
            throw new InterpreterError("Cannot assign a value to this variable");
        }
    }
    
}
