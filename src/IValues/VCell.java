package IValues;

public class VCell implements IValue {
    private IValue value;

    public VCell(IValue value) {
        this.value = value;
    }

    public IValue getValue() {
        return value;
    }

    public void setValue(IValue value) {
        this.value = value;
    }

    public String toStr() {
        return "VCell(" + value.toString() + ")";
    }
}