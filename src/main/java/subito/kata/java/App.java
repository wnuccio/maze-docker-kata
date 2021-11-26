package subito.kata.java;

import subito.kata.java.inout.InputReader;
import subito.kata.java.inout.Output;
import subito.kata.java.inout.OutputWriter;
import subito.kata.java.room.Maze;
import subito.kata.java.room.Route;
import subito.kata.java.room.RouteFinder;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class App {
    private InputReader inputReader;
    private RouteFinder routeFinder;
    private OutputWriter outputWriter;

    public static void main(String[] args) {
        Output output = createOutput(args);

        App app = new App(
                new InputReader("input.json"),
                new RouteFinder(),
                new OutputWriter(output));

        app.execute();
    }

    private static Output createOutput(String[] args) {
        PrintStream optionalOutput = args.length > 0 ? outputStream(args[0]) : null;
        return new Output(System.out, optionalOutput);
    }

    private static PrintStream outputStream(String fileName) {
        try {
            return new PrintStream(fileName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
