/**
 * -- This is a frame for the TSP simulation --
 * -- created on 10-4-2015 by Simon Brink --
 */
package Interface;


import Algorithm.Algorithms.Greedy;
import Algorithm.Algorithms.RandomGreedy;
import jdk.internal.org.xml.sax.SAXParseException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame implements ActionListener {

    private JLabel width;
    private JComboBox selectWidth;
    private Integer[] arrayWidth = {10, 25, 50, 100};
    private JButton change;
    private Field field;
    private int selectedWidth;
    private JLabel result;
    private JTextArea displayResult;
    private JButton enumeration;
    private JButton greedy;
    private JButton random;

    private JButton loadOrder;
    private JFileChooser fileOpener;
    private XmlFileObject xml;

    /** In here we create the frame in the constructor, the constructor does not need any parameters.**/
    public Frame() {

        setTitle("TSP Simulation");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        setSize(1020, 1200); // Size of the main frame

        c.insets = new Insets(20, 0, 40, 0);

        /** Option to change the width of Field **/
        width = new JLabel("Width : ");
        c.gridx = 11;
        c.gridy = 0;
        c.ipadx = 5;
        add(width, c);

        selectWidth = new JComboBox(arrayWidth);
        c.gridx = 12;
        add(selectWidth, c);

        /** Change width **/
        change = new JButton("Change");
        c.gridx = 13;
        add(change, c);
        change.addActionListener(this);

        loadOrder = new JButton("Load order...");
        loadOrder.addActionListener(this);
        c.gridx = 14;
        add(loadOrder, c);


        /* Field grid */
        field = new Field(10);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 10;
        c.gridheight = 10;
        c.ipadx = 1000;
        c.ipady = 1000;
        c.fill = GridBagConstraints.CENTER;
        add(field, c);

        enumeration = new JButton("Enumeration");
        c.gridx = 11;
        c.gridy = 5;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.ipadx = 0;
        c.ipady = 0;
        add(enumeration, c);
        enumeration.addActionListener(this);

        greedy = new JButton("Greedy");
        c.gridx = 13;
        c.gridy = 5;
        c.gridwidth = 2;
        add(greedy, c);
        greedy.addActionListener(this);

        random = new JButton("Random");
        c.gridx = 15;
        c.gridwidth = 2;
        c.gridy = 5;
        add(random, c);
        random.addActionListener(this);


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
        if (e.getSource() == change) {
            selectedWidth = selectWidth.getSelectedIndex();
            this.getWidth(selectedWidth);
        } else if (e.getSource() == random) {
            RandomGreedy algorithm = new RandomGreedy(field);
//            Result result = new Result();
//            result.setVisible(true);
            algorithm.getResult();
        } else if(e.getSource() == greedy) {
            Greedy algorithm = new Greedy(field);
            algorithm.getResult();
        } else if (e.getSource() == enumeration) {

        } else if (e.getSource() == loadOrder) {
            try {
                fileOpener = new JFileChooser();
                fileOpener.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileOpener.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));

                if (fileOpener.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    xml = new XmlFileObject(fileOpener.getSelectedFile());
                    System.out.println(xml.getCustomer().getLastname());
                    System.out.println(xml.getDatum());
                    for (int i = 0; i < xml.getArtikelnummer().size(); i++) {
                        System.out.println(xml.getArtikelnummer().get(i));
                    }
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Selected invalid file");
            } catch (SAXParseException ex) {
                JOptionPane.showMessageDialog(this, "Selected invalid file");
            }
        }
    }
}
