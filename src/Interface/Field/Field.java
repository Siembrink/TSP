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
        this.amount = amount;
        int x = 0;
        int y = 0;

        int count = 1;
        while (count < amount) {
            grid.add(new Point(count, x, y));
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
