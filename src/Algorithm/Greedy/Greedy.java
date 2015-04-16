/**
 * -- Greedy algorithm class --
 * This class contains the algorithm for the Greedy TSP method.
 * Greedy will calculate the nearest point from the one it's
 * currently at so it will follow a path of nearest points.
 */

package Algorithm.Greedy;

import Algorithm.*;

import Interface.Field;
import Interface.Point;

import java.util.ArrayList;

public class Greedy extends Algorithm {

    private Point current;
    private Point closest;
    private Field field;
    private double totalDistance;

    public Greedy(Field field) {
        super(field.getGrid());
        this.field = field;
        current = initial;
        totalDistance = 0;
        calculate();
    }

    @Override
    public void calculate() {
        double closestDistance = 999999999;

        boolean loop = true;
        int count = 0;
        int gridSize = grid.size();


        while (loop) {
            if (!(current.getIndex() == 201285)) {
                grid.remove(current);
            }

            for (Point point : grid) {
                System.out.println(current.calculateDistance(point));
                if (current.calculateDistance(point) <= closestDistance) {
                    closestDistance = current.calculateDistance(point);
                    closest = point;
                }
            }
            System.out.println("LOOP " + count + "\nCURRENT: " + current.toString() + "\nNEW: " + closest.toString());

            totalDistance += current.calculateDistance(closest);
            current = closest;


            field.drawLine(current, closest);

            closestDistance = 999999;
            if (grid.size() == 0) {
                System.out.println("LOOP OVER");
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
