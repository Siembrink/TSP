/**
 * -- Greedy algorithm class --
 * This class contains the algorithm for the Greedy TSP method.
 * Greedy will calculate the nearest point from the one it's
 * currently at so it will follow a path of nearest points.
 */

package Algorithm.Algorithms;

import Algorithm.Algorithm;
import Interface.Field;
import Interface.Point;

public class Greedy extends Algorithm {

    private Point current;
    private Point closest;
    private Field field;
    private double totalDistance;

    public Greedy(Field field) {
        super(field.getGrid());
        this.field = field;
        field.clearLines();
        current = initial;
        totalDistance = 0;
        calculate();
    }

    @Override
    public void calculate() {
        System.out.println("#------ Simulation Start (Greedy / Nearest Neighbor) ------#");
        double closestDistance = 999999999;

        int count = 0;
        int gridSize = grid.size();


        while (true) {
            if (!(current.getIndex() == 201285)) {
                grid.remove(current);
            }

            for (Point point : grid) {
                if (current.calculateDistance(point) <= closestDistance) {
                    closestDistance = current.calculateDistance(point);
                    closest = point;
                }
            }

            totalDistance += current.calculateDistance(closest);
            field.drawLine(current, closest, count);
            current = closest;



            closestDistance = 999999;
            if (grid.size() == 0) {
                field.removeLine(count);
                break;
            }

            if (count != gridSize) {
                count++;
            } else {
                break;
            }
        }
    }

    @Override
    public void getResult() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Greedy{" +
                "current=" + current +
                ", closest=" + closest +
                ", totalDistance=" + totalDistance +
                '}';
    }
}
