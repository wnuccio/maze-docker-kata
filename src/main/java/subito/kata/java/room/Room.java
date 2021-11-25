package subito.kata.java.room;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Room {
    int id;
    String name;
    List<NamedObject> objects;
    Integer east;
    Integer west;

    Room() {
        objects = new ArrayList<>();
    }

    public static RoomBuilder build() {
        return new RoomBuilder();
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

    public void collectObjectsAndBuildRoute(List<Room> rooms, Route route) {
        route.addRoom(this);
        if (east != null) {
            Room eastRoom = rooms.stream()
                    .filter(room -> room.id() == east)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException(format("No such start room: %s ", east)));

            eastRoom.collectObjectsAndBuildRoute(rooms, route);
        }
    }
}
