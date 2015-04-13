/**
 * -- This is a frame for the TSP simulation --
 * <p>
 * <p>
 * <p>
 * -- created on 10-4-2015 by Simon Brink --
 */
package Interface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame implements ActionListener {

    private JLabel width;
    private JComboBox selectWidth;
    private String[] arrayWidth = {"100", "1000", "500"};

    private JButton reset;
    private JButton start;
    private JButton stop;

    private JLabel result;
    private JTextArea displayResult;

    private JButton enumeration;
    private JButton greedy;
    private JButton random;

    public Frame() {

        setTitle("TSP Simulation");
        setLayout(new FlowLayout());
        setSize(1020, 1200);

        width = new JLabel("Width : ");
        add(width);
        selectWidth = new JComboBox(arrayWidth);
        add(selectWidth);

        reset = new JButton("Reset");
        add(reset);
        reset.addActionListener(this);

        start = new JButton("Start");
        add(start);
        start.addActionListener(this);

        stop = new JButton("Stop");
        add(stop);
        stop.addActionListener(this);

        enumeration = new JButton("Enumeration");
        add(enumeration);
        enumeration.addActionListener(this);

        greedy = new JButton("Greedy");
        add(greedy);
        greedy.addActionListener(this);

        random = new JButton("Random");
        add(random);
        random.addActionListener(this);

        add(new Field());

        result = new JLabel("Result : ");
        add(result);

        displayResult = new JTextArea("hallo");
        add(displayResult);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
