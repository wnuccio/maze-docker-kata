package subito.kata.java.inout;

import java.io.PrintStream;

public class Output {
    private PrintStream outStream1;
    private PrintStream outStream2;

    public Output(PrintStream outStream1, PrintStream outputFile) {
        this.outStream1 = outStream1;
        this.outStream2 = outputFile;
    }

    public void println(String s) {
        outStream1.println(s);
        if (outStream2 != null) outStream2.println(s);
    }

    public void printf(String s, String... args) {
        outStream1.printf(s, (Object[]) args);
        if (outStream2 != null) outStream2.printf(s, (Object[]) args);
    }
}
