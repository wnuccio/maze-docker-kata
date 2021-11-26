package subito.kata.java.input;

public class Args {
    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public String outputFile() {
        return args.length > 0 ? args[0] : null;
    }
}
