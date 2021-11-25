package subito.kata.java.room;

import subito.kata.java.inout.Input;

import java.util.ArrayList;
import java.util.List;

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

    public void collectObjectsAndBuildRoute(Input input, Route route) {
        if (alreadyTraversed(route)) return;

        route.addRoom(this);
        if (east != null) {
            Room eastRoom = input.findRoomById(east);
            eastRoom.collectObjectsAndBuildRoute(input, route);
        }
        if (west != null) {
            Room eastRoom = input.findRoomById(west);
            eastRoom.collectObjectsAndBuildRoute(input, route);
        }
    }

    private boolean alreadyTraversed(Route route) {
        return route.contains(this);
    }
}
