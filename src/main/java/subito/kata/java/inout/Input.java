package subito.kata.java.inout;

import subito.kata.java.room.Room;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Input {

    List<Room> rooms;
    Integer startRoomId;
    private List<String> objectsToCollect;

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

    public List<String> objectsToCollect() {
        return objectsToCollect;
    }

    public Room startRoom() {
        return rooms.stream()
                .filter(room -> room.id() == startRoomId)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(format("No such start room: %s ", startRoomId)));
    }
}
