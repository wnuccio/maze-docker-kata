package subito.kata.java.room;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import subito.kata.java.inout.Input;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RouteFinderTest {

    private RouteFinder routeFinder = new RouteFinder();

    @Test
    void build_an_empty_route_from_an_empty_room_list() {
        Input input = Input.build().noRoom();

        Route route = routeFinder.findRouteFrom(input);

        assertThat(route.isEmpty()).isTrue();
    }

    @Test
    void build_a_route_with_one_room() {
        Input input = Input.build()
                .withRoom(Room.build().withId(3).withObjects("Knife"))
                .startFromRoom(3)
                .collect("Knife");

        Route route = routeFinder.findRouteFrom(input);

        assertTraversedRoomsAre(route, 3);
    }

    @Test
    /*
        Rooms:
        (1*) -- (2)
     */
    void build_a_route_with_two_rooms() {
        Input input = Input.build()
                .withRoom(Room.build().withId(1).withObjects("Plant").withEast(2))
                .withRoom(Room.build().withId(2).withObjects("Knife").withWest(1))
                .startFromRoom(1)
                .collect("Plant", "Knife");

        Route route = routeFinder.findRouteFrom(input);

        assertTraversedRoomsAre(route, 1, 2);
    }

    @Test
    /*
        Rooms:
        (1) -- (2*)
     */
    void build_a_route_with_two_rooms_and_start_from_the_second() {
        Input input = Input.build()
                .withRoom(Room.build().withId(1).withObjects("Plant").withEast(2))
                .withRoom(Room.build().withId(2).withObjects("Knife").withWest(1))
                .startFromRoom(2)
                .collect("Plant", "Knife");

        Route route = routeFinder.findRouteFrom(input);

        assertTraversedRoomsAre(route, 2, 1);
    }

    @Test
    /*
        Rooms in a square:
           (3) -- (4)
            |      |
           (2) -- (1*)
     */
    void build_a_route_with_four_rooms_in_a_square() {
        Input input = Input.build()
                .withRoom(Room.build().withId(3).withEast(4).withSouth(2).withObjects("Obj3"))
                .withRoom(Room.build().withId(4).withWest(3).withSouth(1).withObjects("Obj4"))
                .withRoom(Room.build().withId(1).withNorth(4).withWest(2).withObjects("Obj1"))
                .withRoom(Room.build().withId(2).withNorth(3).withEast(1).withObjects("Obj2"))
                .startFromRoom(1)
                .collect("Obj1", "Obj2", "Obj3", "Obj4");

        Route route = routeFinder.findRouteFrom(input);

        assertTraversedRoomsAre(route, 1, 2, 3, 4);
    }

    @Disabled
    @Test
    /*
        Rooms in a row:
           (1) -- (2*) -- (3)
     */
    void build_a_route_with_three_rooms_in_a_row_starting_in_the_middle() {
        Input input = Input.build()
                .withRoom(Room.build().withId(1).withEast(2).withObjects("Obj1"))
                .withRoom(Room.build().withId(2).withWest(1).withEast(3).withObjects("Obj2"))
                .withRoom(Room.build().withId(3).withWest(2).withObjects("Obj3"))
                .startFromRoom(2)
                .collect("Obj1", "Obj2", "Obj3", "Obj4");

        Route route = routeFinder.findRouteFrom(input);

        assertTraversedRoomsAre(route, 2, 1, 2, 3);
    }

    private void assertTraversedRoomsAre(Route route, Integer... ids) {
        List<Integer> roomIds = route.traversedRooms().stream().map(Room::id).collect(Collectors.toList());
        assertThat(route.traversedRooms()).first().matches(startRoom -> startRoom.id() == ids[0]);
        assertThat(roomIds).containsExactlyInAnyOrder(ids);
    }
}