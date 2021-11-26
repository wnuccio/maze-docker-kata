package subito.kata.java.input;

import java.util.Optional;

public class Args {
    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public String inputFile() {
        if (args.length < 1) throw new IllegalArgumentException("Missing 'input file' parameter;");
        return args[0];
    }

    public Optional<String> outputFile() {
        return Optional.ofNullable(args.length == 2 ? args[1] : null);
    }
}
