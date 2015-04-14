/**
 * -- This is a frame for the TSP simulation --
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
    private Integer[] arrayWidth = {10, 25, 50, 100};

    private JButton reset;
    private JButton start;
    private JButton stop;
    private Field field;
    private int selectedWidth;

    private JLabel result;
    private JTextArea displayResult;

    private JButton enumeration;
    private JButton greedy;
    private JButton random;

    /** In here we create the frame in the constructor, the constructor does not need any parameters.**/
    public Frame() {

        setTitle("TSP Simulation");
        setLayout(new FlowLayout());
        setSize(1020, 1200); // Size of the main frame

        width = new JLabel("Width : ");
        add(width);
        selectWidth = new JComboBox(arrayWidth);
        add(selectWidth);



        start = new JButton("Start");
        add(start);
        start.addActionListener(this);



        enumeration = new JButton("Enumeration");
        add(enumeration);
        enumeration.addActionListener(this);

        greedy = new JButton("Greedy");
        add(greedy);
        greedy.addActionListener(this);

        random = new JButton("RandomGreedy");
        add(random);
        random.addActionListener(this);
        result = new JLabel("Result : ");
        add(result);

        displayResult = new JTextArea("hallo");
        add(displayResult);
        field = new Field(10);
        add(field);




        setLocationRelativeTo(null); // Centers
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);


    }

    public void getWidth(int Index) {
        if(Index == 0) {
            field.resetField(10);
        } else if(Index == 1) {
            field.resetField(25);
        } else if (Index == 2) {
            field.resetField(50);
        } else {
            field.resetField(100);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == start) {
            selectedWidth = selectWidth.getSelectedIndex();
            this.getWidth(selectedWidth);
        }
    }
}
