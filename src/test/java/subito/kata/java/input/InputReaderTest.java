package subito.kata.java.input;

import org.junit.jupiter.api.Test;
import subito.kata.java.inout.Input;
import subito.kata.java.inout.InputReader;
import subito.kata.java.room.NamedObject;
import subito.kata.java.room.Room;

import static org.assertj.core.api.Assertions.assertThat;

class InputReaderTest {

    @Test
    void read_a_maze_with_one_room_and_one_object() {
        Input input = new InputReader("./src/test/resources/test.json").readInput();

        assertThat(input.startRoomId()).isEqualTo(1);
        assertThat(input.objectsToCollect()).containsExactly("An object");
        assertThat(input.rooms()).hasSize(1);

        Room room = input.rooms().get(0);

        assertThat(room.id()).isEqualTo(1);
        assertThat(room.name()).isEqualTo("A room");
        assertThat(room.objects()).hasSize(1);

        NamedObject object = room.getObject(0);
        assertThat(object.name()).isEqualTo("An object");
    }
}