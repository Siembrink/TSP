package Algorithm.Algorithms;

import Algorithm.Algorithm;
import Interface.Field;
import Interface.Point;

import java.util.ArrayList;
import java.util.List;

public class Enumeration extends Algorithm {

    private Field field;
    private List<Route> routes;

    private Route shortestRoute;
    private int shortestRouteDistance;

    private Route permuteRoute;
    private double permuteShortestDistance;

    public Enumeration(Field field) {
        super(field.getGrid());
        this.field = field;
        routes = new ArrayList<>();

        // Set empty routes
        shortestRoute = new Route(initial);

        shortestRouteDistance = 9999999;
        permuteShortestDistance = 9999999;
        calculate();
    }

    @Override
    public void calculate() {
        System.out.println("#------ Simulation Start (Full enumeration) ------#");

        // Calculate all possible combinations
        permute(grid, 0);

        System.out.println(routes.toString());
        for (Route route : routes) {
            if (route.getTotalDistance() < shortestRouteDistance) {
                shortestRoute = route;
                shortestRouteDistance = route.getTotalDistance();
            }
        }

        field.drawRoute(shortestRoute);

        System.out.println("Beste route: " + shortestRoute.toString());
        System.out.println("Afstand: " + shortestRoute.getTotalDistance());
    }

    public void permute(java.util.List<Point> arr, int k){
        /**
         * This is the array builder that calls itself to
         * calculate every possible combination of a given
         * list of points.
         *
         * #-- DO NOT CALCULATE MORE THAN 10 POINTS --#
         * Will overflow the RAM usage and crash the application.
         * TODO: Optimize the algorithm
         */

        for (int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }

        if ((k == arr.size() - 1)) {
            Route route = new Route(initial);
            for (Point point : arr) {
                route.add(point);
            }
            routes.add(route);
            System.out.println("Enum route: " + route.toStringRoute());
        }
    }

    private double calculateTotalDistance(List<Point> route) {
        /** Calculate the total distance of a given list of points. **/
        int distance = 0;
        Point current = initial;

        for (Point point : route) {
            if (!(point == route.get(route.size() - 1))) {
                distance += current.calculateDistance(point);
            }
        }

        return distance;
    }

    @Override
    public void getResult() {

    }

}
