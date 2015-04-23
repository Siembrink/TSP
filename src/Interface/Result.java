package Interface;

import Algorithm.SimResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Siem on 17-4-2015.
 */
public class Result extends JDialog implements ActionListener {

    private JButton generate;
    private JButton cancel;
    private JLabel steps;
    private JLabel distance;
    private JLabel algorithmUsed;

    private String algorithm;
    private double totalDistance;
    private int totalSteps;

    public Result(String algorithm, double totalDistance, int totalSteps) {

        this.algorithm = algorithm;
        this.totalDistance = totalDistance;
        this.totalSteps = totalSteps;

        setTitle("Results Simulation");
        setLayout(new FlowLayout());
        setSize(400, 200);
        algorithmUsed = new JLabel("Used Algorithm: " + algorithm);
        add(algorithmUsed);

        distance = new JLabel("Total Distance: " + totalDistance);
        add(distance);

        steps = new JLabel("Total Steps: " + totalSteps);
        add(steps);

        generate = new JButton("Generate");
        add(generate);
        generate.addActionListener(this);

        cancel = new JButton("Cancel");
        add(cancel);
        cancel.addActionListener(this);

        setLocationRelativeTo(null); // Centers
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
        } else if (e.getSource() == generate) {
            JOptionPane.showMessageDialog(this, "Results generated in console.");
            SimResult result = new SimResult("Random Greedy", totalDistance, totalSteps);
            System.out.println(result);
        }

    }
}

