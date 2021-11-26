package subito.kata.java.input;

import subito.kata.java.maze.Room;
import subito.kata.java.maze.RoomBuilder;

import java.util.Arrays;

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

    public InputBuilder startFromRoom(Integer i) {
        input.startRoomId = i;
        return this;
    }

    public Input collect(String... objects) {
        input.objectsToCollect.addAll(Arrays.asList(objects));
        return this.input;
    }
}