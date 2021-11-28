package subito.kata.java.output;

import subito.kata.java.maze.NamedObject;
import subito.kata.java.maze.Room;
import subito.kata.java.maze.Route;

import java.io.PrintStream;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class OutputWriter {
    private final PrintStream outputStream;

    public OutputWriter(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writeOutput(Route route) {
        printFormatted("ID", "Room", "Object collected");
        outputStream.println("-------------------------------------");
        route.traversedRooms().forEach(this::printRoom);
    }

    private void printFormatted(String id, String room, String objectsCollected) {
        outputStream.printf("%-4s %-15s %s %n", id, room, objectsCollected);
    }

    private void printRoom(Room room) {
        String objects = objectString(room);
        printFormatted(valueOf(room.id()), room.name(), objects);
    }

    private String objectString(Room room) {
        if (room.objects().isEmpty()) return "None";
        return room.objects()
                .stream()
                .map(this::objectName)
                .collect(Collectors.joining(" "));
    }

    private String objectName(NamedObject namedObject) {
        return namedObject.name() == null || namedObject.name().isEmpty() ? "None" : namedObject.name();
    }
}
