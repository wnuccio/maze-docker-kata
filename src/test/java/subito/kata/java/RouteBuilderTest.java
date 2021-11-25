package subito.kata.java;

import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class RouteBuilderTest {

    @Test
    void build_an_empty_route_from_an_empty_room_list() {
        Route route = new RouteBuilder().buildRouteFrom(new Input(emptyList(), 0, emptyList()));

        assertThat(route.isEmpty()).isTrue();
    }
}