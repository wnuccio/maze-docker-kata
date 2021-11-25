package subito.kata.java;

public class App {
    private InputReader inputReader;
    private RouteBuilder routeBuilder;
    private OutputWriter outputWriter;

    public App(InputReader inputReader, RouteBuilder routeBuilder, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.routeBuilder = routeBuilder;
        this.outputWriter = outputWriter;
    }

    public static void main(String[] strings) {
        App app = new App(
                new InputReader("input.json"),
                new RouteBuilder(),
                new OutputWriter("output.txt"));

        app.execute();
    }

    private void execute() {
        Input input = inputReader.readInput();
        Route route = routeBuilder.buildRouteFrom(input);
        outputWriter.writeOutput(route);
    }
}
