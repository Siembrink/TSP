package Algorithm;

public class SimResult {

    private String algorithm;
    private double totalDistance;
    private int totalSteps;

    public SimResult(String algorithm, double totalDistance, int totalSteps) {
        this.algorithm = algorithm;
        this.totalDistance = totalDistance;
        this.totalSteps = totalSteps;

    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    @Override
    public String toString() {
        return "-----Results-----\n" +
                "Used Algorithm: " + algorithm + "\n" +
                "Total Distance: " + totalDistance + "\n" +
                "Total Steps: " + totalSteps;
    }
}

