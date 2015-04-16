package Algorithm;

public class SimResult {

    private String algorithm;
    private double totalDistance;
    private int totalSteps;
    private int fieldSize;

    public SimResult(String algorithm, double totalDistance, int totalSteps, int fieldSize) {
        this.algorithm = algorithm;
        this.totalDistance = totalDistance;
        this.totalSteps = totalSteps;
        this.fieldSize = fieldSize;
    }

    @Override
    public String toString() {
        return "SimResult{" +
                "algorithm='" + algorithm + '\'' +
                ", totalDistance=" + totalDistance +
                ", totalSteps=" + totalSteps +
                ", fieldSize=" + fieldSize +
                '}';
    }
}
