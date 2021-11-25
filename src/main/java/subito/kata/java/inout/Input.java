package subito.kata.java.inout;

import subito.kata.java.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Input {

    List<Room> rooms;
    private Integer startRoomId;
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

    public int startRoomId() {
        return startRoomId;
    }

    public List<String> objectsToCollect() {
        return objectsToCollect;
    }
}
