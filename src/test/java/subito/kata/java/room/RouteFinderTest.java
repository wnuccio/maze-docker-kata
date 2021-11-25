package subito.kata.java.room;

import org.junit.jupiter.api.Test;
import subito.kata.java.inout.Input;

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
}