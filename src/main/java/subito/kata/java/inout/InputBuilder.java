package subito.kata.java.inout;

import subito.kata.java.room.Room;
import subito.kata.java.room.RoomBuilder;

public class InputBuilder {

    private final Input input;

    public Input noRoom() {
        return new Input();
    }

    public InputBuilder() {
        this.input = new Input();
    }

    public InputBuilder withRoom(Room room) {
        input.rooms.add(room);
        return this;
    }

    public InputBuilder withRoom(RoomBuilder roomBuilder) {
        return withRoom(roomBuilder.build());
    }

    public InputBuilder startFromRoom(int i) {
        return this;
    }

    public Input collect(String... objects) {
        return this.input;
    }
}
