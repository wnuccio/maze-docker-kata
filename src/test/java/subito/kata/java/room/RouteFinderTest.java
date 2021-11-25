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
                .withRoom(Room.build()
                        .withId(3)
                        .withName("Kitchen")
                        .withObjects("Knife"))
                .startFromRoom(3)
                .collect("Knife");

        Route route = routeFinder.findRouteFrom(input);

        assertThat(route.rooms()).hasSize(1);
        assertThat(route.rooms()).first().matches(room -> room.id() == 3);
    }


    @Test
    void build_a_route_with_two_rooms() {
        Input input = Input.build()
                .withRoom(Room.build()
                        .withId(1)
                        .withName("Hallway")
                        .withObjects("Plant")
                        .withEast(2))
                .withRoom(Room.build()
                        .withId(2)
                        .withName("Kitchen")
                        .withObjects("Knife")
                        .withWest(1))
                .startFromRoom(1)
                .collect("Plant", "Knife");

        Route route = routeFinder.findRouteFrom(input);

        List<Integer> roomIds = route.rooms().stream().map(Room::id).collect(Collectors.toList());
        assertThat(roomIds).containsExactly(1, 2);
    }
}