package Interface;

import Algorithm.SimResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Siem on 17-4-2015.
 * This will generate a extra JFrame with the algorithm's results.
 * The user gets the options to display the results in the console.
 */
public class Result extends JDialog implements ActionListener {

    private JButton generate;
    private JButton close;
    private JLabel steps;
    private JLabel distance;
    private JLabel algorithmUsed;
    private JLabel time;

    private String algorithm;
    private double totalDistance;
    private int totalSteps;
    private long totalTime;

    /** Constructer asks for results and displays it in a JDialog. **/
    public Result(String algorithm, double totalDistance, int totalSteps, long totalTime) {

        this.algorithm = algorithm;
        this.totalDistance = totalDistance;
        this.totalSteps = totalSteps;
        this.totalTime = totalTime;

        setTitle("Results Simulation");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setSize(250, 200);
        algorithmUsed = new JLabel("Used Algorithm: " + algorithm + "\n");
        add(algorithmUsed);

        time = new JLabel("Total Time: " + totalTime);
        add(time);

        distance = new JLabel("Total Distance: " + totalDistance);
        add(distance);

        steps = new JLabel("Total Steps: " + totalSteps);
        add(steps);

        generate = new JButton("Generate");
        add(generate);
        generate.addActionListener(this);

        close = new JButton("Cancel");
        add(close);
        close.addActionListener(this);

        setLocationRelativeTo(null); // Centers
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close) {
            setVisible(false); // Close dialog
            /* Generate result in console */
        } else if (e.getSource() == generate) {
            JOptionPane.showMessageDialog(this, "Results generated in console.");
            SimResult result = new SimResult("Random Greedy", totalDistance, totalSteps, totalTime);
            System.out.println(result);
            setVisible(false);
        }

    }
}

