package ASTNodes;

import java.util.*;
import IValues.*;
import Env.*;
import Error.*;

public class ASTLet implements ASTNode {
    List<Bind> decls;
    ASTNode body;

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        Environment<IValue> env = e.beginScope();
        for (Bind b : decls) {
            env.assoc(b.getId(), b.getExp().eval(env));
        }
        return body.eval(env);
    }

    public ASTLet(List<Bind> decls, ASTNode b) {
        this.decls = decls;
        body = b;
    }

}
