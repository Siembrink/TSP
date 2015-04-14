package Algorithm;

public class Result {

    private String algorithm;
    private double totalDistance;
    private int totalSteps;
    private int fieldSize;

    public Result(String algorithm, double totalDistance, int totalSteps, int fieldSize) {
        this.algorithm = algorithm;
        this.totalDistance = totalDistance;
        this.totalSteps = totalSteps;
        this.fieldSize = fieldSize;
    }

    @Override
    public String toString() {
        return "Result{" +
                "algorithm='" + algorithm + '\'' +
                ", totalDistance=" + totalDistance +
                ", totalSteps=" + totalSteps +
                ", fieldSize=" + fieldSize +
                '}';
    }
}
