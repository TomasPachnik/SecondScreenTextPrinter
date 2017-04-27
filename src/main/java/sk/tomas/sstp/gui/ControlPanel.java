package sk.tomas.sstp.gui;

import sk.tomas.sstp.main.App;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tomas on 4/24/17.
 */
public class ControlPanel extends JFrame implements Runnable {

    private App app;
    private JTextArea area;
    private Point p;

    public ControlPanel(App app, Point p) {
        this.app = app;
        this.p = p;
    }

    public void showFrame() {

        JPanel panel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setTitle("Second Screen Text Printer");
        setVisible(true);

        panel.setBackground(Color.LIGHT_GRAY);

        area = new JTextArea();
        area.setColumns(50);
        area.setRows(20);

        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setText("asdasd");

        panel.add(area);

        JButton button = new JButton();

        button.setText("bla bla bla");

        panel.add(button);

        int CANVAS_HEIGHT = 480;
        int CANVAS_WIDTH = 640;
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        Container cp = getContentPane();
        cp.add(panel);

        inicializeListeners();

        setLocation(p);
        pack();
        setVisible(true);
    }

    private void inicializeListeners() {
        if (area != null) {
            area.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateText(area.getText());
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateText(area.getText());
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateText(area.getText());
                }
            });
        }
    }

    private void updateText(String text) {
        app.updateText(text);
    }

    @Override
    public void run() {
        showFrame();
    }
}
