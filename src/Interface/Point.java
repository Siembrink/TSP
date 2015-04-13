/**
 * -- Point class for the field grid --
 * One object made by this class represents one point in the
 * grid map.
 */

package Interface;

public class Point {

    private int index;
    private String status;
    private int x;
    private int y;

    public Point(int index, int x, int y) {
        this.index = index;
        this.status = "";
        this.x = x;
        this.y = y;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double calculateDistance(Point newPoint) {
        double distance = Math.sqrt(
                ((newPoint.getX() - this.getX()) * (newPoint.getX() - this.getX())) +
                        ((newPoint.getY() - this.getY()) * (newPoint.getY() * this.getY()))
        );
        return distance;
    }
}
