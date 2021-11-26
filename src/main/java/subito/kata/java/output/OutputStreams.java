package subito.kata.java.output;

import java.io.PrintStream;

public class OutputStreams {
    private PrintStream mandatoryStream;
    private PrintStream optionalStream;

    public OutputStreams(PrintStream mandatoryStream, PrintStream optionalStream) {
        this.mandatoryStream = mandatoryStream;
        this.optionalStream = optionalStream;
    }

    public void println(String s) {
        mandatoryStream.println(s);
        if (optionalStream != null) optionalStream.println(s);
    }

    public void printf(String s, String... args) {
        mandatoryStream.printf(s, (Object[]) args);
        if (optionalStream != null) optionalStream.printf(s, (Object[]) args);
    }
}
