package Interface.Old;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    private Canvas canvas;
    private JButton start;
    private JButton reset;

    public Frame() {
        setTitle("TSP Simulator");
        setSize(new Dimension(1280, 720));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initialize();
    }

    private void initialize() {
        add(canvas = new Canvas());
        add(start = new JButton("Start"));
        start.addActionListener(this);
        add(reset = new JButton("Reset"));
        reset.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            canvas.startSearch();
        } else if (e.getSource() == reset) {
            System.out.println("Reset code moet nog gemaakt worden");
        }
    }


}
