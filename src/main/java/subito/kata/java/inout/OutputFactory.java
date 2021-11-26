package subito.kata.java.inout;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputFactory {

    public Output createOutput(String[] args) {
        PrintStream optionalOutput = args.length > 0 ? outputStream(args[0]) : null;
        return new Output(System.out, optionalOutput);
    }

    private PrintStream outputStream(String fileName) {
        try {
            return new PrintStream(fileName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
