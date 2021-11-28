package subito.kata.java.maze;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MazeTest {

    @Test
    void find_a_room_by_id() {
        Maze maze = new InputBuilder()
                .withRoom(new RoomBuilder().withId(1).withName("room1").build())
                .withRoom(new RoomBuilder().withId(2).withName("room2").build())
                .withRoom(new RoomBuilder().withId(3).withName("room3").build())
                .collect("");

        Room room2 = maze.findRoomById(2);
        assertThat(room2.id()).isEqualTo(2);
        assertThat(room2.name()).isEqualTo("room2");
    }
}