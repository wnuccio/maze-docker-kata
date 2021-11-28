package subito.kata.java.maze;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class RouteTest {

    @Test
    void each_room_in_route_is_an_already_traversed_room() {
        Route route = new Route();
        route.addRoom(roomWithObjects(1));
        route.addRoom(roomWithObjects(2));

        assertThat(route.hasAlreadyTraversed(1)).isTrue();
        assertThat(route.hasAlreadyTraversed(2)).isTrue();
        assertThat(route.hasAlreadyTraversed(3)).isFalse();
    }

    @Test
    void route_contains_all_objects_inside_its_rooms() {
        Route route = new Route();
        route.addRoom(roomWithObjects(1, "Knife"));
        route.addRoom(roomWithObjects(2, "Chair", "Key"));
        route.addRoom(roomWithObjects(3));
        route.addRoom(roomWithObjects(4, "Desk"));

        assertThat(route.containsAllObjects(asList("Knife", "Chair", "Key", "Desk"))).isTrue();
        assertThat(route.containsAllObjects(asList("Chair", "Desk"))).isTrue();
        assertThat(route.containsAllObjects(asList("Chair", "Desk", "???"))).isFalse();
    }

    private Room roomWithObjects(int id, String... strings) {
        return new RoomBuilder().withId(id).withObjects(strings).build();
    }
}