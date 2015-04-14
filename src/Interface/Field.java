/**
 * -- Field class for the simulation grid --
 * This class is the GUI for the simulation grid, and handles
 * the way you interact with the grid like clicking on points
 * to add them to the simulation.
 */

package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Field extends JPanel implements MouseListener {

    private int columns;
    private ArrayList<Point> grid;

    public Field(int columns) {
        this.columns = columns;
        grid = new ArrayList<Point>();
        setPreferredSize(new Dimension(1001, 1001));
        addMouseListener(this);
        initializeField();
    }

    public void initializeField() {
        /**
         * This method creates all the points of the grid and
         * generates their coordinates, which are used to draw
         * the points onto the gridmap.
         *
         *
         // 10 columns -> 100px wide 100px high | 100 points
         // 25 columns ->  40px wide  40px high | 625 points
         // 50 columns ->  20px wide  20px high | 2500 points
         // 100columns ->  10px wide  10px high | 10000 points
         */

        int pointSize = 10;
        int maxRow = 100;
        int gridSize = 10000;
        int rowCount = 1;

        if (columns == 10) {
            pointSize = 100;
            maxRow = 10;
            gridSize = 100;
        } else if (columns == 25) {
            pointSize = 40;
            maxRow = 25;
            gridSize = 625;
        } else if (columns == 50) {
            pointSize = 20;
            maxRow = 50;
            gridSize = 2500;
        } else if (columns == 100) {
            pointSize = 10;
            maxRow = 100;
            gridSize = 10000;
        }

        int x = 0;
        int y = 0;
        int count = 0;

        // Start making the points and add them to the grid
        while (count < gridSize) {
            // Add a new point to the grid
            grid.add(new Point(count, x, y));

            if (rowCount == maxRow) {
                y += pointSize;
                x = 0;
                rowCount = 1;
            } else {
                rowCount++;
                x += pointSize;
            }

            count++;
        }
    }

    private void selectPoint(MouseEvent e) {
        /**
         * This method gets the block coordinates of the point
         * the user clicks on, so it can later be used to paint
         * the graphic another color.
         */
        int rootX = e.getX() - (e.getX() % 10);
        int rootY = e.getY() - (e.getY() % 10);

        for (Point point : grid) {
            if ((rootX == point.getX()) && (rootY == point.getY())) {
                point.setStatus("SELECTED");
            }
        }

        repaint();
    }

    public void paintComponent(Graphics brush) {
        /**
         * This method is the graphics drawing class, it loops
         * over the grid and adds the points, as well as other
         * graphics needed to make the grid UI.
         */
        // Set the background
        brush.setColor(Color.WHITE);
        brush.fillRect(0, 0, 1001, 1001);

        // Add all the blocks
        for (Point point : grid) {

            if (point.getStatus().equals("SELECTED")) {
                brush.setColor(Color.GREEN);

                brush.fillRect(point.getX() + 1, point.getY() + 1, 10, 10);

                // Draw the lines between points
                for (Point linepoint : grid) {
                    if ((linepoint.getStatus().equals("SELECTED"))) {
                        brush.setColor(Color.BLUE);
                        brush.drawLine(point.getX() + 5, point.getY() + 5, linepoint.getX() + 5, linepoint.getY() + 5);
                    }
                }
            }

            // Draw the grid lines
            brush.setColor(Color.GRAY);
            brush.drawRect(point.getX(), point.getY(), 10, 10);
        }
    }

    /* #------ Abstract Methods ------# */
    @Override
    public void mouseClicked(MouseEvent e) {
        selectPoint(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
