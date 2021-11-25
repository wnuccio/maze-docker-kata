package subito.kata.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RouteFinderTest {

    @Test
    void build_an_empty_route_from_an_empty_room_list() {
        Input input = new InputBuilder().noRoom();

        Route route = new RouteFinder().findRouteFrom(input);

        assertThat(route.isEmpty()).isTrue();
    }

    @Test
    void build_a_route_with_one_room() {
        Input input = new InputBuilder()
                .withRoom(new RoomBuilder()
                        .withId(3)
                        .withName("Kitchen")
                        .withObjects("Knife")
                        .build())
                .startFromRoom(3)
                .collect("Knife")
                .build();

        Route route = new RouteFinder().findRouteFrom(input);

        assertThat(route.rooms()).hasSize(1);
        assertThat(route.rooms()).first().matches(room -> room.id() == 3);
    }
}