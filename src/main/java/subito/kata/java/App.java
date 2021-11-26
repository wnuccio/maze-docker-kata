package subito.kata.java;

import subito.kata.java.input.InputReader;
import subito.kata.java.maze.Maze;
import subito.kata.java.maze.Route;
import subito.kata.java.maze.RouteFinder;
import subito.kata.java.output.OutputStreams;
import subito.kata.java.output.OutputStreamsFactory;
import subito.kata.java.output.OutputWriter;

public class App {
    private InputReader inputReader;
    private RouteFinder routeFinder;
    private OutputWriter outputWriter;

    public static void main(String[] args) {
        OutputStreams outputStreams = new OutputStreamsFactory().createOutputStreams(args);

        App app = new App(
                new InputReader("input.json"),
                new RouteFinder(),
                new OutputWriter(outputStreams));

        app.execute();
    }

    public App(InputReader inputReader, RouteFinder routeFinder, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.routeFinder = routeFinder;
        this.outputWriter = outputWriter;
    }

    private void execute() {
        Maze maze = inputReader.readInput();
        Route route = routeFinder.findRouteFrom(maze);
        outputWriter.writeOutput(route);
    }
}
