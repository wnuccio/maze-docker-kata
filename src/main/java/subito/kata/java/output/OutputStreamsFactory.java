package subito.kata.java.output;

import subito.kata.java.input.Args;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputStreamsFactory {

    public OutputStreams createOutputStreams(Args parameters) {
        String fileName = parameters.outputFile().orElse(null);
        PrintStream optionalOutputStream = createPrintStream(fileName);
        return new OutputStreams(System.out, optionalOutputStream);
    }

    private PrintStream createPrintStream(String fileName) {
        if (fileName == null) return null;

        try {
            return new PrintStream(fileName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
