package subito.kata.java;

import subito.kata.java.input.Args;
import subito.kata.java.input.InputReader;
import subito.kata.java.maze.Maze;
import subito.kata.java.maze.Route;
import subito.kata.java.maze.RouteFinder;
import subito.kata.java.output.OutputStreamFactory;
import subito.kata.java.output.OutputWriter;

import java.io.PrintStream;

public class App {
    private InputReader inputReader;
    private RouteFinder routeFinder;
    private OutputWriter outputWriter;

    public static void main(String[] args) {
        Args parameters = new Args(args);

        PrintStream outputStream = new OutputStreamFactory()
                .createOutputStream(parameters.outputFile());

        App app = new App(
                new InputReader(parameters.inputFile()),
                new RouteFinder(),
                new OutputWriter(outputStream));

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
