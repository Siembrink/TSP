package Algorithm.Random;

import Algorithm.*;
import Interface.Point;

import java.util.ArrayList;
import java.util.Random;

public class RandomGreedy extends Algorithm {

    private Random randomGenerator;
    private double totalDistance;

    public RandomGreedy(ArrayList<Point> grid) {
        super(grid);
        calculate();
    }

    @Override
    public void calculate() {
        for (Point point : grid) {
            grid.remove(point);

            int index = randomGenerator.nextInt(grid.size());
            Point randomPoint = grid.get(index);

            totalDistance += point.calculateDistance(randomPoint);
            grid.remove(randomPoint);
        }
    }

    @Override
    public void getResult() {

    }
}