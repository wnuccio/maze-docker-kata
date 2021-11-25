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
        if (thisRoomIsAlreadyIn(route)) return;

        route.addRoom(this);
        moveToAdjacentRoom(input, route, east);
        moveToAdjacentRoom(input, route, west);
    }

    private void moveToAdjacentRoom(Input input, Route route, Integer adjacentRouteId) {
        if (adjacentRouteId == null) return;
        Room adjacentRoom = input.findRoomById(adjacentRouteId);
        adjacentRoom.collectObjectsAndBuildRoute(input, route);
    }

    private boolean thisRoomIsAlreadyIn(Route route) {
        return route.contains(this);
    }
}
