package subito.kata.java.room;

import subito.kata.java.inout.Input;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class Room {
    int id;
    String name;
    List<NamedObject> objects;
    Integer north;
    Integer south;
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
        return format("Room[%s]", id);
    }

    public NamedObject getObject(int i) {
        return objects.get(i);
    }

    public void collectObjectsAndBuildRoute(Input input, Route route) {
        if (allObjectsCollected(input, route)) return;
        addThisRoomToRoute(input, route);

        moveToAdjacentRoom(input, south, route);
        moveToAdjacentRoom(input, west, route);
        moveToAdjacentRoom(input, north, route);
        moveToAdjacentRoom(input, east, route);
    }

    private void addThisRoomToRoute(Input input, Route route) {
        if (allObjectsCollected(input, route)) return;
        if (! route.isEmpty() && route.lastId() == this.id) return;
        route.addRoom(this);
    }

    private void moveToAdjacentRoom(Input input, Integer toRoom, Route route) {
        if (toRoom == null) return;
        if (route.contains(toRoom)) return;

        Room adjacentRoom = input.findRoomById(toRoom);
        adjacentRoom.collectObjectsAndBuildRoute(input, route);
        addThisRoomToRoute(input, route);
    }

    private boolean allObjectsCollected(Input input, Route route) {
        List<String> objectsToCollect = input.objectsToCollect();
        List<String> collectedObjects = route.traversedRooms()
                .stream()
                .flatMap(room -> room.objects().stream().map(NamedObject::name))
                .distinct()
                .collect(toList());

        return collectedObjects.containsAll(objectsToCollect);
    }
}
