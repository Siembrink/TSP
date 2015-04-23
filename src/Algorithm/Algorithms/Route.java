package Algorithm.Algorithms;

import Interface.Point;

import java.util.ArrayList;

public class Route {

    private ArrayList<Point> routeList;
    private int totalDistance;
    private boolean status;

    public Route(Point initial) {
        routeList = new ArrayList<>();
        routeList.add(initial);
        status = true;
    }

    public void add(Point point) {
        totalDistance += routeList.get(routeList.size() - 1).calculateDistance(point);
        routeList.add(point);
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeList=" + routeList +
                ", totalDistance=" + totalDistance +
                '}';
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public ArrayList<Point> getRouteList() {
        return routeList;
    }

    public String toStringRoute() {
        String stringbuilder = "Enum Route: ";
        for (Point point : routeList) {
            stringbuilder += point.getIndex() + ", ";
        }
        return stringbuilder;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
