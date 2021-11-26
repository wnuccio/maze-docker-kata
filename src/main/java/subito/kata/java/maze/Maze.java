package subito.kata.java.maze;

import java.util.Set;

public interface Maze {

    Set<String> objectsToCollect();

    Room startRoom();

    boolean hasNoRoom();

    Room findRoomById(int id);
}
