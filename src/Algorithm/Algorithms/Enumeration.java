package Algorithm.Algorithms;


import Algorithm.*;
import Interface.*;

import java.util.ArrayList;


public class Enumeration extends Algorithm {

    private Field field;
    private ArrayList<Route> routeList = new ArrayList<>();
    private double totalDistance;

    public Enumeration(Field field) {
        super(field.getGrid());
        this.field = field;
        calculate();
    }

    @Override
    public void calculate() {

        System.out.println("-----Simulation Begins-----");
        possibleRoute();

    }
    public void possibleRoute() {
        Point current;
        ArrayList<String> indexRoute = new ArrayList<>();
        String currentRoute = "";
        double routeDistance = 0;
        Point lastUsed = initial;
        int index = 0;
        int p = 0;
        while (p < 5) {
            for (int i = 0; i < grid.size(); i++) {
                current = grid.get(i);
                System.out.println("Current Index: " + current.getIndex());
                currentRoute += current.getIndex() + ",";
                System.out.println("Current Route: " + currentRoute);
                routeDistance += current.calculateDistance(lastUsed);
                System.out.println("Route Distance: " + routeDistance + "\n");
                lastUsed = current;
            }

            if (indexRoute.contains(currentRoute)) {
                System.out.println("Route already known.");
            } else {
                indexRoute.add(index, currentRoute);
            }
        p++;
        }



    }


    @Override
    public void getResult() {

    }
}