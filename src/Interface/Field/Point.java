/**
 * -- Point class for the field grid --
 * One object made by this class represents one point in the
 * grid map.
 */

package Interface.Field;

public class Point {

    private int index;
    private String status;
    private int x;
    private int y;

    public Point(int index, int x, int y) {
        // Leave the status at NULL
        this.index = index;
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
}
