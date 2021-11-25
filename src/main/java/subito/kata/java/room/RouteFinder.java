package subito.kata.java.room;

import subito.kata.java.inout.Input;

public class RouteFinder {
    public Route findRouteFrom(Input input) {
        if (input.hasNoRoom()) return new Route();

        Route route = new Route();
        Room startRoom = input.startRoom();
        startRoom.collectObjectsAndBuildRoute(route);
        return route;
    }
}
