package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTBox implements ASTNode {
    private ASTNode exp;

    public ASTBox(ASTNode exp) {
        this.exp = exp;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v = exp.eval(e);
        return new VCell(v);
    }

}
