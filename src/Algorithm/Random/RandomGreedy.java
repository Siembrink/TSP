package Algorithm.Random;

import Algorithm.*;
import Interface.Point;

import java.util.ArrayList;
import java.util.Random;

public class RandomGreedy extends Algorithm {

    private Random randomGenerator;
    private double totalDistance;
    private int totalSteps;

    public RandomGreedy(ArrayList<Point> grid) {
        super(grid);
        randomGenerator = new Random();
        calculate();
    }

    @Override
    public void calculate() {

        int arrayLength = grid.size();
        int loopCounter = 0;
        totalDistance = initial.calculateDistance(grid.get(0));
        Point current = grid.get(0);


        while (loopCounter < arrayLength) {
            System.out.println(grid.toString());
            System.out.println("Loop begin | LoopCount: " + loopCounter + "\n------------\nCount: " + loopCounter);
            System.out.println("Current point: " + current.toString());
            grid.remove(current);

            int index = randomGenerator.nextInt(grid.size());
            System.out.println("Random number: " + index);
            Point random = grid.get(index);
            totalDistance += current.calculateDistance(random);
            System.out.println("Random point: " + random.toString());

            System.out.println("Total distance: " + totalDistance);

            current = random;

            System.out.println("Current changed: " + current.toString());

            loopCounter++;
        }
        System.out.println("End sim");
    }

    @Override
    public void getResult() {
        SimResult result = new SimResult("Random", totalDistance, totalSteps, 25);
        System.out.println(result.toString());
    }
}