package subito.kata.java.room;

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
    void build_a_route_with_two_rooms_and_start_from_the_second() {
        Input input = Input.build()
                .withRoom(Room.build().withId(1).withObjects("Plant").withEast(2))
                .withRoom(Room.build().withId(2).withObjects("Knife").withWest(1))
                .startFromRoom(2)
                .collect("Plant", "Knife");

        Route route = routeFinder.findRouteFrom(input);

        assertTraversedRoomsAre(route, 2, 1);
    }

    private void assertTraversedRoomsAre(Route route, Integer... ids) {
        List<Integer> roomIds = route.traversedRooms().stream().map(Room::id).collect(Collectors.toList());
        assertThat(roomIds).containsExactly(ids);
    }
}