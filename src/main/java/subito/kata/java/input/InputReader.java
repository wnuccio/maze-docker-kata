package subito.kata.java.input;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class InputReader {
    private String inputFile;

    public InputReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public Input readInput() {
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(inputFile));
            return new Gson().fromJson(jsonReader, Input.class);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
