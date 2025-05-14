package IValues;

public class VBool implements IValue {
    boolean vBool;

    public VBool(boolean bool) {
        vBool = bool;
    }

    public boolean getval() {
        return vBool;
    }

    public String toStr() {
        return Boolean.toString(vBool);
    }
}