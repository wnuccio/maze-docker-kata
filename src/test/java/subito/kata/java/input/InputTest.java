package subito.kata.java.input;

import org.junit.jupiter.api.Test;
import subito.kata.java.maze.Room;
import subito.kata.java.maze.RoomBuilder;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    @Test
    void find_a_room_by_id() {
        Input input = new InputBuilder()
                .withRoom(new RoomBuilder().withId(1).withName("room1").build())
                .withRoom(new RoomBuilder().withId(2).withName("room2").build())
                .withRoom(new RoomBuilder().withId(3).withName("room3").build())
                .collect("");

        Room room2 = input.findRoomById(2);
        assertThat(room2.id()).isEqualTo(2);
        assertThat(room2.name()).isEqualTo("room2");
    }
}