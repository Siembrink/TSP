package Algorithm.Algorithms;


import Algorithm.Algorithm;
import Interface.*;


public class Enumeration extends Algorithm {

    private Field field;
    private double totalDistance;

    public Enumeration(Field field) {
        super(field.getGrid());
        this.field = field;
        calculate();
    }

    @Override
    public void calculate() {


    }

    @Override
    public void getResult() {

    }
}