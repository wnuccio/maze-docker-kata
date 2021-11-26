package subito.kata.java;

import subito.kata.java.inout.InputReader;
import subito.kata.java.inout.OutputStream;
import subito.kata.java.inout.OutputStreamFactory;
import subito.kata.java.inout.OutputWriter;
import subito.kata.java.room.Maze;
import subito.kata.java.room.Route;
import subito.kata.java.room.RouteFinder;

public class App {
    private InputReader inputReader;
    private RouteFinder routeFinder;
    private OutputWriter outputWriter;

    public static void main(String[] args) {
        OutputStream outputStream = new OutputStreamFactory().createOutputStream(args);

        App app = new App(
                new InputReader("input.json"),
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
