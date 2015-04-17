package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Siem on 17-4-2015.
 */
public class Result extends JDialog implements ActionListener {

    private JButton jbOk;
    private JLabel jlResult;
    private JLabel jlPoints;
    private JLabel jlPointsResult;

    public Result() {

        setTitle("Results Simulation");
        setLayout(new FlowLayout());
        setSize(200, 400);
        jlResult = new JLabel("Simulation Results: ");
        add(jlResult);
        jlPoints = new JLabel("Selected Points: ");
        jlPointsResult = new JLabel();
        add(jlPoints);
        add(jlPointsResult);

        jbOk = new JButton("Ok");
        jbOk.setLocation(100,100);
        add(jbOk);

        jbOk.addActionListener(this);

        setLocationRelativeTo(null); // Centers

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbOk) {
            setVisible(false);
        }

    }
}

