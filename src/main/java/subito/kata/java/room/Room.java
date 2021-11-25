package subito.kata.java.room;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

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

    public void collectObjectsAndBuildRoute(Maze maze, Route route) {
        if (route.allObjectsAreCollected(maze)) return;
        addCurrentRoomToRoute(route);

        moveToAdjacentRoom(maze, south, route);
        moveToAdjacentRoom(maze, west, route);
        moveToAdjacentRoom(maze, north, route);
        moveToAdjacentRoom(maze, east, route);
    }

    private void moveToAdjacentRoom(Maze maze, Integer toRoom, Route route) {
        if (thereIsNoRoomHere(toRoom)) return;
        if (route.hasAlreadyTraversed(toRoom)) return;

        Room adjacentRoom = maze.findRoomById(toRoom);
        adjacentRoom.collectObjectsAndBuildRoute(maze, route);

        if (route.allObjectsAreCollected(maze)) return;
        addCurrentRoomToRoute(route);
    }

    private void addCurrentRoomToRoute(Route route) {
        route.addRoom(this);
    }

    private boolean thereIsNoRoomHere(Integer toRoom) {
        return toRoom == null;
    }

}
