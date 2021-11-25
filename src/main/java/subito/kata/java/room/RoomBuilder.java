package subito.kata.java.room;

public class RoomBuilder {

    private final Room room;

    public RoomBuilder() {
        this.room = new Room();
    }

    public RoomBuilder withId(int id) {
        room.id = id;
        return this;
    }

    public RoomBuilder withName(String name) {
        room.name = name;
        return this;
    }

    public RoomBuilder withObjects(String objects) {
        room.objects.add(new NamedObject(objects));
        return this;
    }

    public RoomBuilder withEast(int id) {
        room.east = id;
        return this;
    }

    public RoomBuilder withWest(int id) {
        room.west = id;
        return this;
    }

    public Room build() {
        return this.room;
    }
}
