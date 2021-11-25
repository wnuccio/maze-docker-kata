package subito.kata.java;

public class RouteFinder {
    public Route findRouteFrom(Input input) {
        if (input.rooms().isEmpty()) return new Route();

        Route route = new Route();
        route.addRoom(input.rooms().get(0));
        return route;
    }
}
