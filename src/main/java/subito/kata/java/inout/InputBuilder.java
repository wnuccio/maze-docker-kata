package subito.kata.java.inout;

import subito.kata.java.room.Room;

import static java.util.Collections.emptyList;

public class InputBuilder {

    private final Input input;

    public Input noRoom() {
        return new Input(emptyList(), null, emptyList());
    }

    public InputBuilder() {
        this.input = new Input();
    }

    public InputBuilder withRoom(Room room) {
        input.rooms.add(room);
        return this;
    }

    public InputBuilder startFromRoom(int i) {
        return this;
    }

    public InputBuilder collect(String objects) {
        return this;
    }

    public Input build() {
        return this.input;
    }
}
