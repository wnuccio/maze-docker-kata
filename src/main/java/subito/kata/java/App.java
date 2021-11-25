package subito.kata.java;

public class App {
    public static void main(String[] strings) {
        Input input = readInput("input.json");
        Route route = buildRouteFrom(input);
        writeOutput(route, "output.txt");
    }

    private static Route buildRouteFrom(Input input) {
        return null;
    }

    private static Input readInput(String inputFile) {
        return new InputReader(inputFile).readInput();
    }

    private static void writeOutput(Route input, String outputFile) {
    }
}
