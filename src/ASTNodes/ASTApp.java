package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public class ASTApp implements ASTNode {
    ASTNode func;
    ASTNode value;

    public IValue eval(Environment<IValue> env) throws InterpreterError {
        IValue funcValue = func.eval(env);
        if (!(funcValue instanceof VClos)) {
            throw new InterpreterError("Expected a VClos, but got incorrect type : " + funcValue.getClass().getSimpleName());
        }
        VClos clos = (VClos) funcValue;
        Environment<IValue> fnEnv = clos.getEnv();
        fnEnv.assoc(clos.getParam(), value.eval(fnEnv));
        return clos.getBody().eval(fnEnv);
    }

    ASTApp(ASTNode func, ASTNode value) {
        this.func = func;
        this.value = value;
    }
}