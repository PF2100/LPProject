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
        Environment<IValue> fnEnv = clos.getEnv().beginScope();
        fnEnv.assoc(clos.getParam(), value.eval(env));
        IValue v = clos.getBody().eval(fnEnv);
        return v;
    }

    public ASTApp(ASTNode func, ASTNode value) {
        this.func = func;
        this.value = value;
    }
}