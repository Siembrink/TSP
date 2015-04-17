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
        int indexPoint = 0;
        totalDistance = initial.calculateDistance(grid.get(0));


        System.out.println("------Begin Simulation------");
        System.out.println("Selected Points: "+ arrayLength);
        while (loopCounter < arrayLength) {
            Point current = grid.get(indexPoint);
            randomGenerator.nextInt(arrayLength);

            System.out.println("Standing on Index: " + randomGenerator.toString());
            System.out.println(current);
            System.out.println("Loop count: " + loopCounter);

            System.out.println("\n");
            loopCounter++;
            indexPoint++;

        }
        System.out.println("------End Simulation------");
    }

    @Override
    public void getResult() {
        SimResult result = new SimResult("Random", totalDistance, totalSteps, 25);
        System.out.println(result.toString());
    }
}