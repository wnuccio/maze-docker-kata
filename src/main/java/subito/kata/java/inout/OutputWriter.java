package subito.kata.java.inout;

import subito.kata.java.room.NamedObject;
import subito.kata.java.room.Room;
import subito.kata.java.room.Route;

import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class OutputWriter {
    private final Output output;

    public OutputWriter(String outputFile) {
        this.output = new Output(System.out, outputFile);
    }

    public void writeOutput(Route route) {
        printFormatted("ID", "Room", "Object collected");
        output.println("------------------------------------");
        route.traversedRooms().forEach(this::printRoom);
    }

    private void printFormatted(String id, String room, String objectsCollected) {
        output.printf("%-4s %-15s %-9s%n", id, room, objectsCollected);
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
