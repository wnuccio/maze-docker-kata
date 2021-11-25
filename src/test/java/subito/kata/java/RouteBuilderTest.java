package subito.kata.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RouteBuilderTest {

    @Test
    void build_an_empty_route_from_an_empty_room_list() {
        Input input = new InputBuilder().noRoom();

        Route route = new RouteBuilder().buildRouteFrom(input);

        assertThat(route.isEmpty()).isTrue();
    }
}