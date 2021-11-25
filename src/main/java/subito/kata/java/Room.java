package subito.kata.java;

import java.util.List;

public class Room {
    private int id;
    private String name;
    private List<NamedObject> objects;

    public Room(int id, String name, List<NamedObject> objects) {
        this.id = id;
        this.name = name;
        this.objects = objects;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public List<NamedObject> objects() {
        return objects;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }

    public NamedObject getObject(int i) {
        return objects.get(i);
    }
}
