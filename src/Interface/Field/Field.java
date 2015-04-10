/**
 * -- Field class for the simulation grid --
 * This class is the GUI for the simulation grid, and handles
 * the way you interact with the grid like clicking on points
 * to add them to the simulation.
 */

package Interface.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Field extends JPanel implements MouseListener {

    private int size;
    private ArrayList<Point> grid;

    public Field() {
        setPreferredSize(new Dimension(1001, 1001));
        addMouseListener(this);
        initializeField();
    }

    public void initializeField() {
        // Make a grid of 100x100
        this.size = 100;
        int x = 0;
        int y = 0;
        int rowCount = 1;
        int count = 1;

        // Start making the points and add them to the grid
        while (count < size) {
            // Add a new point to the grid
            grid.add(new Point(count, x, y));

            if (rowCount == 10) {
                y += 10;
                x = 0;
                rowCount = 1;
            } else {
                rowCount++;
                x += 10;
            }

            count++;
        }
    }

    private void selectPoint(MouseEvent e) {
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
            brush.setColor(Color.BLACK);
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
