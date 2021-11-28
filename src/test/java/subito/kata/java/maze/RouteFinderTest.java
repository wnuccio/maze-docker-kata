package subito.kata.java.maze;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RouteFinderTest {

    private RouteFinder routeFinder = new RouteFinder();

    @Test
    void build_an_empty_route_from_an_empty_room_list() {
        Maze maze = new MazeBuilder().noRoom();

        Route route = routeFinder.findRouteFrom(maze);

        assertThat(route.traversedRooms()).isEmpty();
    }

    @Test
    void build_a_route_with_one_room() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(3).withObjects("Knife"))
                .startFromRoom(3)
                .collect("Knife");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 3);
    }

    @Test
    // Rooms: (1*) -- (2)
    void build_a_route_with_two_rooms() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(1).withObjects("Plant").withEast(2))
                .withRoom(new RoomBuilder().withId(2).withObjects("Knife").withWest(1))
                .startFromRoom(1)
                .collect("Plant", "Knife");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 1, 2);
    }

    @Test
    // Rooms: (1*) -- (2)
    void build_a_route_with_two_rooms_and_objects_all_in_the_second_room() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(1).withObjects().withEast(2))
                .withRoom(new RoomBuilder().withId(2).withObjects("Plant", "Knife").withWest(1))
                .startFromRoom(1)
                .collect("Plant", "Knife");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 1, 2);
    }

    @Test
    // Rooms: (1) -- (2*)
    void build_a_route_with_two_rooms_starting_from_the_second() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(1).withObjects("Plant").withEast(2))
                .withRoom(new RoomBuilder().withId(2).withObjects("Knife").withWest(1))
                .startFromRoom(2)
                .collect("Plant", "Knife");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 2, 1);
    }

    @Test
    // Rooms:
    //         (3) -- (4)
    //          |      |
    //         (2) -- (1*)
    void build_a_route_with_four_rooms_in_a_square() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(3).withEast(4).withSouth(2).withObjects("Obj3"))
                .withRoom(new RoomBuilder().withId(4).withWest(3).withSouth(1).withObjects("Obj4"))
                .withRoom(new RoomBuilder().withId(1).withNorth(4).withWest(2).withObjects("Obj1"))
                .withRoom(new RoomBuilder().withId(2).withNorth(3).withEast(1).withObjects("Obj2"))
                .startFromRoom(1)
                .collect("Obj1", "Obj2", "Obj3", "Obj4");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 1, 2, 3, 4);
    }

    @Test
    // Rooms: (1) -- (2*) -- (3)
    void build_a_route_with_three_rooms_in_a_row_starting_in_the_middle() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(1).withEast(2).withObjects("Obj1"))
                .withRoom(new RoomBuilder().withId(2).withWest(1).withEast(3).withObjects("Obj2"))
                .withRoom(new RoomBuilder().withId(3).withWest(2).withObjects("Obj3"))
                .startFromRoom(2)
                .collect("Obj1", "Obj2", "Obj3");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 2, 1, 2, 3);
    }

    @Test
    // Rooms: (1*) -- (2)
    void build_an_empty_route_when_object_list_is_empty() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(1).withObjects("Plant").withEast(2))
                .withRoom(new RoomBuilder().withId(2).withObjects("Knife").withWest(1))
                .startFromRoom(1)
                .collect();

        Route route = routeFinder.findRouteFrom(maze);

        assertThat(route.traversedRooms()).isEmpty();
    }

    @Test
    // Rooms: (1*) -- (2) -- (3)
    void stop_immediately_when_object_list_is_complete() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(1).withObjects("Knife").withEast(2))
                .withRoom(new RoomBuilder().withId(2).withObjects("Plant").withWest(1).withEast(3))
                .withRoom(new RoomBuilder().withId(3).withObjects("Key").withWest(2))
                .startFromRoom(1)
                .collect("Knife", "Plant");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 1, 2);
    }

    @Test
    // Rooms: (1) -- (2*) -- (3)
    void stop_when_all_rooms_are_traversed_even_if_object_list_is_uncomplete() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(1).withEast(2)) // empty room
                .withRoom(new RoomBuilder().withId(2).withObjects("Knife").withWest(1).withEast(3))
                .withRoom(new RoomBuilder().withId(3).withObjects("Plant").withWest(2))
                .startFromRoom(2)
                .collect("Plant", "Knife", "???");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 2, 1, 2, 3, 2);
    }

    @Test
    // Rooms: (1*) -- (2) -- (3)
    void traverse_irrilevant_rooms_until_object_list_is_complete() {
        Maze maze = new MazeBuilder()
                .withRoom(new RoomBuilder().withId(1).withEast(2)) // empty room
                .withRoom(new RoomBuilder().withId(2).withObjects("Knife").withWest(1).withEast(3))
                .withRoom(new RoomBuilder().withId(3).withObjects("Plant").withWest(2))
                .startFromRoom(1)
                .collect("Plant");

        Route route = routeFinder.findRouteFrom(maze);

        assertTraversedRoomsAre(route, 1, 2, 3);
    }

    private void assertTraversedRoomsAre(Route route, Integer... ids) {
        List<Integer> roomIds = route.traversedRooms().stream().map(Room::id).collect(Collectors.toList());
        assertThat(route.traversedRooms()).first().matches(startRoom -> startRoom.id() == ids[0]);
        assertThat(roomIds).containsExactlyInAnyOrder(ids);
    }
}