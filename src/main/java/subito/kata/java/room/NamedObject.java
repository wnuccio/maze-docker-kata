package subito.kata.java.room;

public class NamedObject {
    private String name;

    public NamedObject(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
