package subito.kata.java.output;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputStreamsFactory {

    public OutputStreams createOutputStreams(String[] args) {
        PrintStream optionalOutputStream = args.length > 0 ? createPrintStream(args[0]) : null;
        return new OutputStreams(System.out, optionalOutputStream);
    }

    private PrintStream createPrintStream(String fileName) {
        try {
            return new PrintStream(fileName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
