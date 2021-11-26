package subito.kata.java.output;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputStreamsFactory {

    public OutputStreams createOutputStreams(String outputFile) {
        PrintStream optionalOutputStream =
                outputFile.isEmpty() ? null : createPrintStream(outputFile);

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
