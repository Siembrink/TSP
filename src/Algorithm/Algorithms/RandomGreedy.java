package Algorithm.Algorithms;

import Algorithm.Algorithm;
import Interface.Field;
import Interface.Point;

import java.util.Random;

public class RandomGreedy extends Algorithm {

    private Random randomGenerator;
    private Field field;
    private double totalDistance;
 //   private int totalSteps;

    public RandomGreedy(Field field) {
        super(field.getGrid());
        this.field = field;
        field.clearLines();
        randomGenerator = new Random();
        calculate();
    }

    @Override
    public void calculate() {

        int arrayLength = grid.size();
        int loopCounter = 0;
        Point lastPoint = initial;

        totalDistance = initial.calculateDistance(grid.get(0));


        System.out.println("------Begin Simulation------");
        System.out.println("Selected Points: "+ arrayLength);
        while (loopCounter < arrayLength) {
            Point current = grid.get(randomGenerator.nextInt(grid.size()));

            System.out.println("Standing on Index: " + current.getIndex() + ",  X=" + current.getX() + ", Y=" + current.getY());
            System.out.println("Loop count: " + loopCounter);

            field.drawLine(lastPoint, current, loopCounter);
            double distance = lastPoint.calculateDistance(current);
            System.out.println("Distance Between Last and Current: " + distance);
            totalDistance += distance;
            System.out.println("New distance: " + totalDistance);

            lastPoint = current;
            grid.remove(current);

            loopCounter++;

        }
        System.out.println("------End Simulation------\n");

        System.out.println("------Results------");
        System.out.println("Algorithm: RandomGreedy");
        System.out.println("Total Distance: " + totalDistance);

    }

    @Override
    public void getResult() {
//        SimResult result = new SimResult("Random", totalDistance, totalSteps, 25);
//        System.out.println(result.toString());


    }
}