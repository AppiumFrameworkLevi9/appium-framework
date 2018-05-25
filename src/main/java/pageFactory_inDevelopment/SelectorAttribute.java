package pageFactory_inDevelopment;

public final class SelectorAttribute {

    private SelectorType type;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SelectorType getType() {
        return type;
    }

    public void setType(SelectorType type) {
        this.type = type;
    }
}