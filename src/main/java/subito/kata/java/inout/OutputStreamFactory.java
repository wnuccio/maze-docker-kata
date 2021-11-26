package subito.kata.java.inout;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputStreamFactory {

    public OutputStream createOutputStream(String[] args) {
        PrintStream optionalOutputStream = args.length > 0 ? createPrintStream(args[0]) : null;
        return new OutputStream(System.out, optionalOutputStream);
    }

    private PrintStream createPrintStream(String fileName) {
        try {
            return new PrintStream(fileName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
