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

        assertThat(input.rooms()).hasSize(3);
        Room room2 = input.rooms().get(1);
        assertThat(room2.id()).isEqualTo(2);
        assertThat(room2.name()).isEqualTo("room2");
    }
}