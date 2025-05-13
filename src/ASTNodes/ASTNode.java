package ASTNodes;

import IValues.*;
import Env.*;
import Error.*;

public interface ASTNode {

    public IValue eval(Environment<IValue> e) throws InterpreterError;

}
