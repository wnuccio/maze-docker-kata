package subito.kata.java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    @Test
    void collect_all_items_in_a_maze_example_1() throws IOException {
        String outputFile = "./output.txt";
        Files.deleteIfExists(Paths.get(outputFile));

        App.main(new String[]{outputFile});

        List<String> lines = Files.readAllLines(Paths.get(outputFile));
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
