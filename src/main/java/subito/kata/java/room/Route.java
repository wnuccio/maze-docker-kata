package subito.kata.java.room;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Route {
    private List<Room> rooms;

    Route() {
        rooms = new ArrayList<>();
    }

    public List<Room> traversedRooms() {
        return this.rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean contains(Integer roomId) {
        return rooms.stream().anyMatch(room -> roomId.equals(room.id()));
    }

    @Override
    public String toString() {
        return rooms.toString();
    }

    public boolean allObjectsAreCollected(Maze maze) {
        return collectedObjects().containsAll(maze.objectsToCollect());
    }

    private List<String> collectedObjects() {
        return traversedRooms()
                .stream()
                .flatMap(room -> room.objects().stream().map(NamedObject::name))
                .distinct()
                .collect(toList());
    }
}
