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

    private String text = "bla bla bla";

    public ControlPanel() {
        JPanel panel = inicializePallette();
        int CANVAS_HEIGHT = 480;
        int CANVAS_WIDTH = 640;
        panel.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        Container cp = getContentPane();
        cp.add(panel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setTitle("Second Screen Text Printer");
        setVisible(true);
    }

    private JPanel inicializePallette() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        JTextArea area = new JTextArea();
        area.setColumns(50);
        area.setRows(20);

        area.setWrapStyleWord(true);
        area.setLineWrap(true);

        panel.add(area);

        JButton button = new JButton();

        button.setText(text);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOnScreen(1, showSecondFrame());
            }
        });

        panel.add(button);

        return panel;
    }

    private static void showOnScreen(int screen, JFrame frame) {
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        if (screen > -1 && screen < gs.length) {
            gs[screen].setFullScreenWindow(frame);
        } else if (gs.length > 0) {
            gs[0].setFullScreenWindow(frame);
        } else {
            throw new RuntimeException("No Screens Found");
        }
    }

    private JFrame showSecondFrame() {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        jPanel.setBackground(Color.BLACK);
        frame.setContentPane(jPanel);

        JTextPane textPane = new JTextPane();

        Font font = new Font(Font.SANS_SERIF, 3, 25);
        textPane.setFont(font);

        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        textPane.setText(text);

        jPanel.add(textPane, gbc);

        return frame;
    }

}
