package subito.kata.java.output;

import java.io.PrintStream;

public class OutputStreams {
    private PrintStream outputStream;

    public OutputStreams(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public void println(String s) {
        outputStream.println(s);
    }

    public void printf(String s, String... args) {
        outputStream.printf(s, (Object[]) args);
    }
}
