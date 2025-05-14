package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTNot implements ASTNode {

    ASTNode exp;

    public ASTNot(ASTNode exp) {
        this.exp = exp;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v1 = exp.eval(e);

        if (v1 instanceof VBool) {
            return new VBool(!((VBool) v1).getval());
        } else {
            throw new InterpreterError("illegal types for ~ operator");
        }
    }
}
