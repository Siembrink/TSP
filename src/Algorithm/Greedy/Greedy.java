/**
 * -- Greedy algorithm class --
 * This class contains the algorithm for the Greedy TSP method.
 * Greedy will calculate the nearest point from the one it's
 * currently at so it will follow a path of nearest points.
 */

package Algorithm.Greedy;

import Algorithm.Algorithm;
import Algorithm.Result;
import Interface.Point;

import java.util.ArrayList;

public class Greedy extends Algorithm {

    private Point current;
    private Point closest;
    private int totalDistance;

    public Greedy(ArrayList<Point> grid) {
        super(grid);
        current = initial;
        totalDistance = 0;
        closest = new Point(92818251, 10295, 10295);
        calculate();
    }

    @Override
    public void calculate() {
        for (Point point : grid) {
            // Calculate the closest point from the current one
            for (Point newPoint : grid) {
                double distance = point.calculateDistance(newPoint);
                if (distance < point.calculateDistance(closest)) {
                    closest = newPoint;
                }
            }

            // Calculate distance from current to new
            totalDistance += point.calculateDistance(closest);

            // Set the current point to the new point
            current = point;
            grid.remove(point);
        }
    }

    @Override
    public Result getResult() {

        Result result = new Result();
        return result;
    }
}
