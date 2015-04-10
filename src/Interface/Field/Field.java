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

    private int amount;
    private ArrayList<Point> grid;

    public Field() {
        setPreferredSize(new Dimension(701, 701));
        addMouseListener(this);
    }

    public void initializeField(int amount) {
        // If the amount is an uneven number, make it even
        if (amount % 2 != 0) {
            amount += 1;
        }

        this.amount = amount;
        int x = 0;
        int y = 0;
        int count = 1;

        // Start making the points and add them to the grid
        while (count < amount) {
            grid.add(new Point(count, x, y));


            count++;
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

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
