package subito.kata.java.input;

import org.junit.jupiter.api.Test;
import subito.kata.java.maze.Maze;
import subito.kata.java.maze.Room;

import static org.assertj.core.api.Assertions.assertThat;

class InputReaderTest {

    @Test
    void read_a_maze_with_one_room_and_one_object() {
        Maze maze = new InputReader("./src/test/resources/test.json").readInput();

        assertThat(maze.startRoomId()).isEqualTo(1);
        assertThat(maze.objectsToCollect()).containsExactly("An object");
        assertThat(maze.rooms()).hasSize(1);

        Room room = maze.rooms().get(0);

        assertThat(room.id()).isEqualTo(1);
        assertThat(room.name()).isEqualTo("A room");
        assertThat(room.objects()).hasSize(1);

        assertThat(room.objects()).hasSize(1);
        assertThat(room.objects()).first().matches(obj -> obj.name().equals("An object"));

    }
}