package subito.kata.java;

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

    public Room build() {
        return this.room;
    }
}
