package subito.kata.java.inout;

import java.io.FileNotFoundException;
import java.io.PrintStream;

class Output {
    private PrintStream out;
    private PrintStream outTemp;

    Output(PrintStream out, String outputFile) {
        this.out = out;
        try {
            outTemp = new PrintStream(outputFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void println(String s) {
        out.println(s);
        outTemp.println(s);
    }

    public void printf(String s, String... args) {
        out.printf(s, (Object[]) args);
        outTemp.printf(s, (Object[]) args);
    }
}
