package subito.kata.java.maze;

import java.util.Arrays;

public class InputBuilder {

    private final Maze maze;

    public Maze noRoom() {
        return new Maze();
    }

    public InputBuilder() {
        this.maze = new Maze();
    }

    public InputBuilder withRoom(Room room) {
        maze.rooms.add(room);
        return this;
    }

    public InputBuilder withRoom(RoomBuilder roomBuilder) {
        return withRoom(roomBuilder.build());
    }

    public InputBuilder startFromRoom(Integer i) {
        maze.startRoomId = i;
        return this;
    }

    public Maze collect(String... objects) {
        maze.objectsToCollect.addAll(Arrays.asList(objects));
        return this.maze;
    }
}
