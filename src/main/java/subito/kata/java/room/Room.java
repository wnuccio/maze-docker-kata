package subito.kata.java.room;

import java.util.ArrayList;
import java.util.List;

public class Room {
    int id;
    String name;
    List<NamedObject> objects;

    public Room(int id, String name, List<NamedObject> objects) {
        this.id = id;
        this.name = name;
        this.objects = objects;
    }

    public Room() {
        objects = new ArrayList<>();
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
