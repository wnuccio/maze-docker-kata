package subito.kata.java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    private Path temporaryOutputFile;

    @BeforeEach
    void setUp() throws IOException {
        temporaryOutputFile = Files.createTempFile("temp", "txt");
    }

    @Test
    /*
        Rooms:
                (3) -- (2*) -- (4)
                        |
                       (1)
     */
    void example_1() throws IOException {

        App.main(new String[]{"./src/test/resources/input1.json", outputFileName()});

        List<String> lines = outputFileLines();
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

    @Test
    /*
        Rooms:
                        (5) -- (6)
                         |      |
                (3) -- (2) -- (4*)
                        |      |
                       (1) -- (7)
     */
    void example_2() throws IOException {

        App.main(new String[]{"./src/test/resources/input2.json", outputFileName()});

        List<String> lines = outputFileLines();
        assertThat(lines.size()).isEqualTo(9);
        assertOutuptIs(lines.get(0), "ID",  "Room",           "Object collected");
        assertOutuptIs(lines.get(1), "------------------------------");
        assertOutuptIs(lines.get(2), "4",   "Sun Room",       "None");
        assertOutuptIs(lines.get(3), "7",   "Living room",    "Potted Plant");
        assertOutuptIs(lines.get(4), "1",   "Hallway",        "None");
        assertOutuptIs(lines.get(5), "2",   "Dining Room",    "None");
        assertOutuptIs(lines.get(6), "3",   "Kitchen",        "Knife");
        assertOutuptIs(lines.get(7), "2",   "Dining Room",    "None");
        assertOutuptIs(lines.get(8), "5",   "Bedroom",        "Pillow");
    }

    private String outputFileName() {
        return temporaryOutputFile.toString();
    }

    private List<String> outputFileLines() throws IOException {
        return Files.readAllLines(temporaryOutputFile);
    }

    private void assertOutuptIs(String line, String... strings) {
        Arrays.asList(strings).forEach(s -> Assertions.assertThat(line).contains(s));
    }
}
