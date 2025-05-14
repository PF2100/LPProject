package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTSeq implements ASTNode {
    ASTNode exp1;
    ASTNode exp2;

    public ASTSeq(ASTNode exp1, ASTNode exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        exp1.eval(e);
        IValue v = exp2.eval(e);
        return v;
    }
}
