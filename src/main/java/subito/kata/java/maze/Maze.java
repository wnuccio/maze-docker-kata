package subito.kata.java.maze;

import java.util.List;

public interface Maze {

    List<String> objectsToCollect();

    Room startRoom();

    boolean hasNoRoom();

    Room findRoomById(int id);
}
