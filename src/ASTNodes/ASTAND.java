package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTAND implements ASTNode {
    ASTNode lhs, rhs;

    public ASTAND(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VBool && v2 instanceof VBool) {
            return new VBool(((VBool) v1).getval() && ((VBool) v2).getval());
        } else {
            throw new InterpreterError("illegal types for && operator");
        }
    }
}
