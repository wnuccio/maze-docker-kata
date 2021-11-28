package subito.kata.java.output;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputStreamsFactory {

    public OutputStreams createOutputStreams(String outputFile) {
        PrintStream outputStream = outputFile.isEmpty() ? System.out : createPrintStream(outputFile);
        return new OutputStreams(outputStream);
    }

    private PrintStream createPrintStream(String fileName) {
        try {
            return new PrintStream(fileName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
