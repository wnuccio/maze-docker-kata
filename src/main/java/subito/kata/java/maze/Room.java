package subito.kata.java.maze;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class Room {
    int id;
    String name;
    Set<ObjectInRoom> objects;
    Integer north;
    Integer south;
    Integer east;
    Integer west;

    Room() {
        objects = new HashSet<>();
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Set<String> objects() {
        return objects.stream().map(ObjectInRoom::name).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return format("Room[%s]", id);
    }

    public void collectObjectsAndBuildRoute(Maze maze, Route route) {
        if (allRequiredObjectsAreCollected(maze, route)) return;
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

        if (allRequiredObjectsAreCollected(maze, route)) return;
        addCurrentRoomToRoute(route);
    }

    private boolean allRequiredObjectsAreCollected(Maze maze, Route route) {
        return route.containsAllObjects(maze.objectsToCollect());
    }

    private void addCurrentRoomToRoute(Route route) {
        route.addRoom(this);
    }

    private boolean thereIsNoRoomHere(Integer toRoom) {
        return toRoom == null;
    }

}
