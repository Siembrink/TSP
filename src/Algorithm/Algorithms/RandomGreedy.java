package Algorithm.Algorithms;

import Algorithm.*;
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




    }

    @Override
    public void getResult() {
        SimResult result = new SimResult("Random Greedy", totalDistance, totalSteps);
        System.out.println(result.toString());


    }
}