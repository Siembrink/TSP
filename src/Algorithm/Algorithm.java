/**
 * -- Algorithm abstract class --
 * Abstract algorithm container so all subclasses are required
 * to make one specific function used for displaying results.
 */

package Algorithm;

import Interface.Point;

import java.util.ArrayList;

public abstract class Algorithm {

    /**
     * This private grid consists only of the points that
     * are selected, so the ones that matter to the
     * simulation.
     */
    public static ArrayList<Point> grid;
    public static Point initial;

    public Algorithm(ArrayList<Point> field) {
        // Add all selected points to the grid
        for (Point point : field) {
            if (point.getStatus().equals("SELECTED")) {
                grid.add(point);
            }
        }

        // Create a new point in the bottom right corner
        initial = new Point(9999, 1000, 1000);
    }

    // Getters and setters
    public ArrayList<Point> getGrid() {
        return grid;
    }

    // Abstract methods
    public abstract void calculate();
    public abstract Result getResult();

}
