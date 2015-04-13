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
    private ArrayList<Point> grid;

    public Algorithm(ArrayList<Point> grid) {
        // Add all selected points to the grid
        for (Point point : grid) {
            if (point.getStatus().equals("SELECTED")) {
                this.grid.add(point);
            }
        }
    }

    // Getters and setters
    public ArrayList<Point> getGrid() {
        return grid;
    }

    // Abstract methods
    public abstract Result getResult();

}
