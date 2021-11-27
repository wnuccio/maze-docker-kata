package subito.kata.java.input;

public class Args {
    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public String inputFile() {
        if (args.length < 1) return "input.json";
        return args[0];
    }

    public String outputFile() {
        return args.length == 2 ? args[1] : "";
    }
}
