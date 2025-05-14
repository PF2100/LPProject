package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;


public class ASTWhile implements ASTNode {
    ASTNode condition;
    ASTNode body;

    public ASTWhile(ASTNode condition, ASTNode body) {
        this.condition = condition;
        this.body = body;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        while (true) {
            IValue condValue = condition.eval(e);

            if (condValue instanceof VBool) {
                if (((VBool) condValue).getval()) {
                    body.eval(e);
                }else{
                    break;
                }

            } else {
                throw new InterpreterError("Condition must be a boolean");
            }
        }
        return null; 
    }
}
