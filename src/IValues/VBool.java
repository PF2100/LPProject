package IValues;

public class VBool implements IValue {
    boolean vBool;

    public VBool(boolean bool) {
        vBool = bool;
    }

    public boolean getBool() {
        return vBool;
    }

    public String toStr() {
        return Boolean.toString(vBool);
    }
}