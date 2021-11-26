package subito.kata.java.input;

import subito.kata.java.maze.Maze;
import subito.kata.java.maze.Room;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Input implements Maze {

    List<Room> rooms;
    Integer startRoomId;
    List<String> objectsToCollect;

    Input() {
        rooms = new ArrayList<>();
        startRoomId = null;
        objectsToCollect = new ArrayList<>();
    }

    public static InputBuilder build() {
        return new InputBuilder();
    }

    public List<Room> rooms() {
        return rooms;
    }

    public Integer startRoomId() {
        return startRoomId;
    }

    @Override
    public List<String> objectsToCollect() {
        return objectsToCollect;
    }

    @Override
    public Room startRoom() {
        return findRoomById(startRoomId);
    }

    @Override
    public boolean hasNoRoom() {
        return rooms().isEmpty();
    }

    @Override
    public Room findRoomById(int id) {
        return rooms.stream()
                .filter(room -> room.id() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(format("No such room: %s ", id)));
    }
}
