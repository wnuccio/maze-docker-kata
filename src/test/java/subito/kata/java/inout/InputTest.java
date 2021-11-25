package subito.kata.java.inout;

import org.junit.jupiter.api.Test;
import subito.kata.java.room.Room;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    @Test
    void find_a_room_by_id() {
        Input input = Input.build()
                .withRoom(Room.build().withId(1).withName("room1").build())
                .withRoom(Room.build().withId(2).withName("room2").build())
                .withRoom(Room.build().withId(3).withName("room3").build())
                .collect("");

        assertThat(input.findRoomById(2).name()).isEqualTo("room2");
    }
}