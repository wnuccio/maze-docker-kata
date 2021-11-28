package subito.kata.java.maze;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class Maze {

    List<Room> rooms;
    Integer startRoomId;
    Set<String> objectsToCollect;

    Maze() {
        rooms = new ArrayList<>();
        startRoomId = null;
        objectsToCollect = new HashSet<>();
    }

    public List<Room> rooms() {
        return rooms;
    }

    public Integer startRoomId() {
        return startRoomId;
    }

    public Set<String> objectsToCollect() {
        return objectsToCollect;
    }

    public Room startRoom() {
        return findRoomById(startRoomId);
    }

    public boolean hasNoRoom() {
        return rooms().isEmpty();
    }

    public Room findRoomById(int id) {
        return rooms.stream()
                .filter(room -> room.id() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(format("No such room: %s ", id)));
    }
}
