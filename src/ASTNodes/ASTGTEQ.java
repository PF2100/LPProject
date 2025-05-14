package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTGTEQ implements ASTNode {

    ASTNode lhs, rhs;

    public ASTGTEQ(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);

        if (v1 instanceof VInt && v2 instanceof VInt) {
            return new VBool(((VInt) v1).getval() >= ((VInt) v2).getval());
        } else {
            throw new InterpreterError("illegal types for >= operator");
        }
    }
}
