package Algorithm.Algorithms;

import Algorithm.Algorithm;
import Interface.Field;
import Interface.Point;

import java.util.ArrayList;
import java.util.List;

public class ObjectEnumeration extends Algorithm {

    private Field field;
    private List<Route> routes;

    public ObjectEnumeration(Field field) {
        super(field.getGrid());
        this.field = field;
        routes = new ArrayList<>();
        calculate();
    }

    @Override
    public void calculate() {
        System.out.println("#------ Simulation Start (Full enumeration) ------#");

        Route shortestRoute = new Route(initial);
        int shortestRouteDistance = 999999;

        // Calculate all possible combinations
        permute(grid, 0);

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

        for (int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }

        if (k == arr.size() -1){
            Route route = new Route(initial);
            for (Point point : arr) {
                route.add(point);
            }
            routes.add(route);
        }
    }

    @Override
    public void getResult() {

    }

}
