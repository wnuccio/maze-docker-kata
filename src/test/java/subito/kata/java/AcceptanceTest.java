package subito.kata.java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    @Test
    /*
        Rooms:
                (3) -- (2*) -- (4)
                        |
                       (1)
     */
    void collect_all_items_in_a_maze_example_1() throws IOException {
        Path tempFile = Files.createTempFile("temp", "txt");

        App.main(new String[]{tempFile.toString()});

        List<String> lines = Files.readAllLines(tempFile);
        assertThat(lines.size()).isEqualTo(8);
        assertOutuptIs(lines.get(0), "ID",  "Room",           "Object collected");
        assertOutuptIs(lines.get(1), "------------------------------");
        assertOutuptIs(lines.get(2), "2",   "Dining Room",    "None");
        assertOutuptIs(lines.get(3), "1",   "Hallway",        "None");
        assertOutuptIs(lines.get(4), "2",   "Dining Room",    "None");
        assertOutuptIs(lines.get(5), "3",   "Kitchen",        "Knife");
        assertOutuptIs(lines.get(6), "2",   "Dining Room",    "None");
        assertOutuptIs(lines.get(7), "4",   "Sun Room",       "Potted Plant");
    }

    private void assertOutuptIs(String line, String... strings) {
        Arrays.asList(strings).forEach(s -> Assertions.assertThat(line).contains(s));
    }
}
