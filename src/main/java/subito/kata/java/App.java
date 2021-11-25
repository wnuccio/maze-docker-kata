package subito.kata.java;

public class App {
    private InputReader inputReader;
    private RouteFinder routeFinder;
    private OutputWriter outputWriter;

    public App(InputReader inputReader, RouteFinder routeFinder, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.routeFinder = routeFinder;
        this.outputWriter = outputWriter;
    }

    public static void main(String[] strings) {
        App app = new App(
                new InputReader("input.json"),
                new RouteFinder(),
                new OutputWriter("output.txt"));

        app.execute();
    }

    private void execute() {
        Input input = inputReader.readInput();
        Route route = routeFinder.findRouteFrom(input);
        outputWriter.writeOutput(route);
    }
}
