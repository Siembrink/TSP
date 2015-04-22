package Interface;

import Algorithm.SimResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel implements ActionListener {

    private SimResult result;

    public ResultPanel(SimResult result) {
        this.result = result;

        setPreferredSize(new Dimension(200, 600));
        add(new JButton("Test button"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
