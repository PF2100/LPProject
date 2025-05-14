
package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTIf implements ASTNode {
    ASTNode condition;
    ASTNode thenBranch;
    ASTNode elseBranch;

    public ASTIf(ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue condValue = condition.eval(e);

        if (condValue instanceof VBool) {
            if (((VBool) condValue).getval()) {
                return thenBranch.eval(e);
            } else {
                return elseBranch.eval(e);
            }
        } else {
            throw new InterpreterError("Condition must be a boolean");
        }
    }
    
}
