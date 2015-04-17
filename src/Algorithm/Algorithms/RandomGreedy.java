package Algorithm.Algorithms;

import Algorithm.Algorithm;
import Algorithm.SimResult;
import Interface.Field;
import Interface.Point;

import java.util.Random;

public class RandomGreedy extends Algorithm {

    private Random randomGenerator;
    private Field field;
    private double totalDistance;
    private int totalSteps;

    public RandomGreedy(Field field) {
        super(field.getGrid());
        this.field = field;
        randomGenerator = new Random();
        calculate();
    }

    @Override
    public void calculate() {

        int arrayLength = grid.size();
        int loopCounter = 0;
        Point test1 = initial;

        totalDistance = initial.calculateDistance(grid.get(0));


        System.out.println("------Begin Simulation------");
        System.out.println("Selected Points: "+ arrayLength);
        while (loopCounter < arrayLength) {
            Point current = grid.get(randomGenerator.nextInt(grid.size()));

            System.out.println("Standing on Index: " + current.getIndex() + ",  X=" + current.getX() +  ", Y=" + current.getY());
            System.out.println("Loop count: " + loopCounter);

            field.drawLine(test1, current, loopCounter);
            test1 = current;
            grid.remove(current);

            System.out.println("\n");
            loopCounter++;

        }
        System.out.println("------End Simulation------");
    }

    @Override
    public void getResult() {
        SimResult result = new SimResult("Random", totalDistance, totalSteps, 25);
        System.out.println(result.toString());
    }
}