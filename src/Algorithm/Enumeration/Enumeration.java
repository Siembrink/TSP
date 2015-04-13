package Algorithm.Enumeration;

import Algorithm.*;
import Interface.Point;

import java.util.ArrayList;

public class Enumeration extends Algorithm{

    public Enumeration(ArrayList<Point> grid) {
        super(grid);
    }

    @Override
    public Result getResult() {
        Result result = new Result();
        return result;
    }
}