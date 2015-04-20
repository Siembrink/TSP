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
    private boolean selected;

    public Point(int index, int x, int y) {
        this.index = index;
        this.status = "";
        selected = false;
        this.x = x;
        this.y = y;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.selected = true;
    }

    public boolean getSelected() {
        return selected;
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
        int x1 = this.getX();
        int y1 = this.getY();
        int x2 = newPoint.getX();
        int y2 = newPoint.getY();

        double diffX = Math.abs(x2 - x1);
        double diffY = Math.abs(y2 - y1);

        double square = (diffX * diffX) + (diffY * diffY);

        return Math.sqrt(square);
    }


    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", status='" + status + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", selected=" + selected +
                '}';
    }
}
