package subito.kata.java.room;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<Room> rooms;

    Route() {
        rooms = new ArrayList<>();
    }

    public boolean isEmpty() {
        return true;
    }

    public List<Room> traversedRooms() {
        return this.rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean contains(Room room) {
        return rooms.stream().anyMatch(r -> r.id() == room.id());
    }

    public boolean contains(Integer roomId) {
        return rooms.stream().anyMatch(room -> roomId.equals(room.id()));
    }

    @Override
    public String toString() {
        return rooms.toString();
    }

    public int lastId() {
        return rooms.get(rooms.size()-1).id;
    }
}
