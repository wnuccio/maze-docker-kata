package subito.kata.java;

import java.util.List;

public class Input {

    private List<Room> rooms;
    private Integer startRoomId;
    private List<String> objectsToCollect;

    public Input(List<Room> rooms, Integer startRoomId, List<String> objectsToCollect) {
        this.rooms = rooms;
        this.startRoomId = startRoomId;
        this.objectsToCollect = objectsToCollect;
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
