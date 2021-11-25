package subito.kata.java;

public class RouteBuilder {
    public Route buildRouteFrom(Input input) {
        if (input.rooms().isEmpty()) return new Route();

        Route route = new Route();
        route.addRoom(input.rooms().get(0));
        return route;
    }
}
