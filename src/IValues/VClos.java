package IValues;

import ASTNodes.*;
import Env.*;

public class VClos implements IValue{
    Environment<IValue> env;
    String param;
    ASTNode body;

    public VClos(Environment<IValue> env, String var, ASTNode body){
        this.env = env;
        this.param = var;
        this.body = body;
    }

    public Environment<IValue> getEnv() {
        return this.env;
    }

    public String getParam(){
        return this.param;
    }

    public ASTNode getBody() {
        return this.body;
    }

    public String toStr() {
        return "Closure has environment" + env.toString() + "with param " + param.toString() + "with body " + body.toString();
    }
    
}
