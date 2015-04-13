package Algorithm.Random;

import Algorithm.*;
import Interface.Point;

import java.util.ArrayList;

public class Random extends Algorithm {

    public Random(ArrayList<Point> grid) {
        super(grid);
    }

    @Override
    public Result getResult() {
        Result result = new Result();
        return result;
    }
}