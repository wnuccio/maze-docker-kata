package subito.kata.java.input;

import org.junit.jupiter.api.Test;
import subito.kata.java.maze.Room;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    @Test
    void find_a_room_by_id() {
        Input input = Input.build()
                .withRoom(Room.build().withId(1).withName("room1").build())
                .withRoom(Room.build().withId(2).withName("room2").build())
                .withRoom(Room.build().withId(3).withName("room3").build())
                .collect("");

        Room room2 = input.findRoomById(2);
        assertThat(room2.id()).isEqualTo(2);
        assertThat(room2.name()).isEqualTo("room2");
    }
}