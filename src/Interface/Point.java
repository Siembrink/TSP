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
        this.x = x;
        this.y = y;
    }

}