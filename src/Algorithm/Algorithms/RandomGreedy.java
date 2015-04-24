/**
 * #--- Random algorithm class ---#
 * This class contains the algorithm for the Random TSP method.
 * Running this algorithm makes the program search for random
 * points all over the selected map and construct a path that way.
 */

package Algorithm.Algorithms;


import Algorithm.Algorithm;
import Interface.*;
import Interface.Field;
import Interface.Point;

import java.util.Random;

public class RandomGreedy extends Algorithm {

    private Random randomGenerator;
    private Field field;
    private double totalDistance;
    private int totalSteps;
    private long startTime;
    private long endTime;
    private long totalTime;

    public RandomGreedy(Field field) {
        super(field.getGrid());
        this.field = field;
        field.clearLines();
        randomGenerator = new Random();
        calculate();
    }

    @Override
    public void calculate() {
        startTime = System.currentTimeMillis();
        int arrayLength = grid.size();
        int loopCounter = 0;
        Point lastPoint = initial;

        totalDistance = initial.calculateDistance(grid.get(0));

        while (loopCounter < arrayLength) {
            Point current = grid.get(randomGenerator.nextInt(grid.size()));
            field.drawLine(lastPoint, current, loopCounter);
            double distance = lastPoint.calculateDistance(current);
            totalDistance += distance;
            lastPoint = current;
            grid.remove(current);
            loopCounter++;
        }
        totalSteps = loopCounter;
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
    }

    @Override
    public void getResult() {
        Result result = new Result("Random Greedy", totalDistance, totalSteps, totalTime);
        System.out.println(result.toString());
    }
}