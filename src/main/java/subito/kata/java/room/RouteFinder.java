package subito.kata.java.room;

import subito.kata.java.inout.Input;

public class RouteFinder {
    public Route findRouteFrom(Input input) {
        if (input.rooms().isEmpty()) return new Route();

        Route route = new Route();
        route.addRoom(input.startRoom());
        return route;
    }
}
