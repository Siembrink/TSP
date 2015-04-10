package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener {

    private ArrayList<IndicatorBlock> blocks;

    public Canvas() {
        setPreferredSize(new Dimension(501, 501));
        addMouseListener(this);
        initializeBlocks();
    }

    private void initializeBlocks() {
        blocks = new ArrayList<IndicatorBlock>();
        int i = 1;
        int c = 0;
        int x = 0;
        int y = 0;

        while (c < 25) {
            blocks.add(new IndicatorBlock(c + 1, false, x, y));

            if (i == 5) {
                y += 100;
                x = 0;
                i = 1;
            } else {
                i++;
                x += 100;
            }

            c++;
        }
    }

    private void select(MouseEvent e) {
        int mouseRootX = e.getX() - (e.getX() % 100);
        int mouseRootY = e.getY() - (e.getY() % 100);

        for (IndicatorBlock block : blocks) {
            if ((mouseRootX == block.getPosX()) && (mouseRootY == block.getPosY())) {
                if (block.isStatus()) {
                    if (block.isStatusLoading()) {
                        block.setStatusDone(true);
                    } else {
                        block.setStatusLoading(true);
                    }
                    //block.setStatus(false);
                } else {
                    block.setStatus(true);
                }
                break;
            }
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        // Set the background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 501, 501);

        // Add all the blocks
        for (IndicatorBlock block : blocks) {

            if (block.isStatus()) {
                if (block.isStatusDone()) {
                    g.setColor(Color.RED);
                } else if (block.isStatusLoading()) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.GREEN);
                }
                g.fillRect(block.getPosX() + 1, block.getPosY() + 1, 100, 100);

                // Draw a line to any other selected blocks
                for (IndicatorBlock lineblock : blocks) {
                    if ((lineblock.isStatus()) && (!lineblock.isStatusDone()) && (!block.isStatusDone())) {
                        g.setColor(Color.blue);
                        g.drawLine(block.getPosX()+50, block.getPosY()+50, lineblock.getPosX()+50, lineblock.getPosY()+50);
                    }
                }
            }

            g.setColor(Color.BLACK);
            g.drawRect(block.getPosX(), block.getPosY(), 100, 100);
        }
    }

    public void startSearch() {
        int distance = 0;

        int x = 500;
        int y = 500;

        for (IndicatorBlock block : blocks) {
            if (block.isStatus()) {
                double partdistance = Math.sqrt(
                        (block.getPosX() - x) * (block.getPosX() - x) +
                                (block.getPosY() - y) * (block.getPosY() - y)
                );
                distance += partdistance;
                System.out.println("ParDistance: " + partdistance + "\nTotalDistance: " + distance);
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        select(e);
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
