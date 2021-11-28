package subito.kata.java.output;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputStreamFactory {

    public PrintStream createOutputStream(String outputFile) {
        return outputFile.isEmpty() ? System.out : createPrintStream(outputFile);
    }

    private PrintStream createPrintStream(String fileName) {
        try {
            return new PrintStream(fileName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
