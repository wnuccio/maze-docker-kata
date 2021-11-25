package subito.kata.java.room;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<Room> rooms = new ArrayList<>();

    public boolean isEmpty() {
        return true;
    }

    public List<Room> rooms() {
        return this.rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
