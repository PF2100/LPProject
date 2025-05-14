package ASTNodes;


import IValues.*;
import Env.*;
import Error.*;

public class ASTStar implements ASTNode  {
    ASTNode exp1;

    public ASTStar(ASTNode exp1) {
        this.exp1 = exp1;
    }
    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v1 = exp1.eval(e);
        if (v1 instanceof VCell) {
            return ((VCell) v1).getValue();
        }
        return v1;
    }   
}
