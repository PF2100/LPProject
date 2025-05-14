package ASTNodes;

import Env.Environment;
import Error.InterpreterError;
import IValues.IValue;
import IValues.VInt;

public class ASTPrint implements ASTNode {
    boolean isPrintLn;
    ASTNode message;

    public ASTPrint(boolean isPrintLn, ASTNode expression) {
        this.isPrintLn = isPrintLn;
        this.message = expression;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue v = message.eval(e);
        if (v instanceof IValue) {
            if (isPrintLn) {
                System.out.println(v.toStr());
            } else {
                System.out.print(v.toStr());
            }
            return v;
        } else {
            throw new InterpreterError("illegal types to try and Print");
        }
    }
}
