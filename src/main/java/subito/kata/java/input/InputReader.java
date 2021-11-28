package subito.kata.java.input;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import subito.kata.java.maze.Maze;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static java.lang.String.format;

public class InputReader {
    private String inputFile;

    public InputReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public Maze readInput() {
        try {
            return readMazeFromInputFile();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(format("Input file missing: '%s'.", inputFile));
        }
    }

    private Maze readMazeFromInputFile() throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(inputFile));
        return new Gson().fromJson(jsonReader, Maze.class);
    }
}
