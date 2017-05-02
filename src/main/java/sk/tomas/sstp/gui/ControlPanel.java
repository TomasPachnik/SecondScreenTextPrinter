package sk.tomas.sstp.gui;

import org.apache.log4j.Logger;
import sk.tomas.servant.annotation.Inject;
import sk.tomas.sstp.main.App;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by tomas on 4/24/17.
 */
public class ControlPanel extends JFrame implements Runnable {
    private final static Logger logger = Logger.getLogger(ControlPanel.class);

    @Inject
    private App app;
    @Inject
    private Point p1;

    private JTextArea jTextArea;

    private void showFrame() {

        JPanel panel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setTitle("Second Screen Text Printer");
        setVisible(true);

        panel.setBackground(Color.LIGHT_GRAY);

        jTextArea = setUpArea();

        panel.add(jTextArea);

        setPreferredSize(new Dimension(640, 480));
        Container cp = getContentPane();
        cp.add(panel);

        inicializeListeners();

        setLocation(p1);
        pack();
        setVisible(true);
    }

    private JTextArea setUpArea() {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setColumns(50);
        jTextArea.setRows(20);

        jTextArea.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);
        jTextArea.setText("");
        return jTextArea;
    }

    private void inicializeListeners() {
        if (jTextArea != null) {
            jTextArea.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateText(jTextArea.getText());
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateText(jTextArea.getText());
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateText(jTextArea.getText());
                }
            });
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                logger.info("App stopped");
                System.exit(0);
            }
        });
    }

    private void updateText(String text) {
        app.updateText(text);
    }

    @Override
    public void run() {
        showFrame();
    }
}
