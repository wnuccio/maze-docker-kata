package subito.kata.java.room;

import org.junit.jupiter.api.Test;
import subito.kata.java.inout.Input;

import static org.assertj.core.api.Assertions.assertThat;

class RouteTest {

    @Test
    void each_room_in_route_is_an_already_traversed_room() {
        Route route = new Route();
        route.addRoom(Room.build().withId(1).build());
        route.addRoom(Room.build().withId(2).build());

        assertThat(route.hasAlreadyTraversed(1)).isTrue();
        assertThat(route.hasAlreadyTraversed(2)).isTrue();
        assertThat(route.hasAlreadyTraversed(3)).isFalse();
    }

    @Test
    void all_objects_inside_rooms_contained_in_route_are_collected() {
        Route route = new Route();
        route.addRoom(Room.build().withId(1).withObjects("Knife").build());
        route.addRoom(Room.build().withId(2).withObjects("Chair", "Key").build());
        route.addRoom(Room.build().withId(3).withObjects().build());
        route.addRoom(Room.build().withId(2).withObjects("Desk").build());

        Maze maze1 = Input.build().collect("Chair", "Desk");
        assertThat(route.allObjectsAreCollected(maze1)).isTrue();

        Maze maze2 = Input.build().collect("Chair", "Desk", "???");
        assertThat(route.allObjectsAreCollected(maze2)).isFalse();
    }
}