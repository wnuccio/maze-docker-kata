package subito.kata.java.input;

import java.util.Optional;

public class Args {
    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public Optional<String> outputFile() {
        return Optional.ofNullable(parameterAt(0));
    }

    private String parameterAt(int index) {
        return args.length > index ? args[index] : null;
    }
}
