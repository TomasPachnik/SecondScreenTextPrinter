package sk.tomas.sstp.gui;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tomas on 4/24/17.
 */
public class ControlPanel extends JFrame {


    public ControlPanel() {

    }

    public JFrame showFrame() {

        JPanel panel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setTitle("Second Screen Text Printer");
        setVisible(true);

        panel.setBackground(Color.LIGHT_GRAY);

        JTextArea area = new JTextArea();
        area.setColumns(50);
        area.setRows(20);

        area.setWrapStyleWord(true);
        area.setLineWrap(true);

        panel.add(area);

        JButton button = new JButton();

        button.setText("bla bla bla");

        panel.add(button);

        int CANVAS_HEIGHT = 480;
        int CANVAS_WIDTH = 640;
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        Container cp = getContentPane();
        cp.add(panel);

        return this;
    }


    private JFrame showSecondFrame() {
        SecondScreenFrame frame = new SecondScreenFrame();
        return frame;
    }

}
