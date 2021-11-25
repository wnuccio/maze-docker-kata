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
        addThisRoomToRoute(maze, route);

        moveToAdjacentRoom(maze, south, route);
        moveToAdjacentRoom(maze, west, route);
        moveToAdjacentRoom(maze, north, route);
        moveToAdjacentRoom(maze, east, route);
    }

    private void addThisRoomToRoute(Maze maze, Route route) {
        if (route.allObjectsAreCollected(maze)) return;
        if (! route.isEmpty() && route.lastId() == this.id) return;
        route.addRoom(this);
    }

    private void moveToAdjacentRoom(Maze maze, Integer toRoom, Route route) {
        if (toRoom == null) return;
        if (route.contains(toRoom)) return;

        Room adjacentRoom = maze.findRoomById(toRoom);
        adjacentRoom.collectObjectsAndBuildRoute(maze, route);
        addThisRoomToRoute(maze, route);
    }

}
