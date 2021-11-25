package subito.kata.java.room;

public class RouteFinder {
    public Route findRouteFrom(Maze maze) {
        if (maze.hasNoRoom()) return new Route();

        Route route = new Route();
        Room startRoom = maze.startRoom();
        startRoom.collectObjectsAndBuildRoute(maze, route);
        return route;
    }
}
