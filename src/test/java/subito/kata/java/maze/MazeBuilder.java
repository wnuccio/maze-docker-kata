package subito.kata.java.maze;

import java.util.Arrays;

public class MazeBuilder {

    private final Maze maze;

    public Maze noRoom() {
        return new Maze();
    }

    public MazeBuilder() {
        this.maze = new Maze();
    }

    public MazeBuilder withRoom(Room room) {
        maze.rooms.add(room);
        return this;
    }

    public MazeBuilder withRoom(RoomBuilder roomBuilder) {
        return withRoom(roomBuilder.build());
    }

    public MazeBuilder startFromRoom(Integer i) {
        maze.startRoomId = i;
        return this;
    }

    public Maze collect(String... objects) {
        maze.objectsToCollect.addAll(Arrays.asList(objects));
        return this.maze;
    }
}
