package sk.tomas.sstp.gui;

import sk.tomas.servant.annotation.Inject;
import sk.tomas.sstp.configuration.PropertyBundle;
import sk.tomas.sstp.main.App;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tomas Pachnik on 25-Apr-17.
 */
public class SecondScreenFrame extends JFrame implements Runnable {

    @Inject
    private App app;
    @Inject
    private PropertyBundle propertyBundle;
    @Inject
    private Point p2;

    private JTextArea jTextArea;


    private void showFrame() {
        JPanel panel = new JPanel();

        //remove entire titlebar
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        // Can not be resized
        setResizable(false);
        //set maximized
        setExtendedState(Frame.MAXIMIZED_BOTH);

        panel.setBackground(Color.BLACK);
        setContentPane(panel);

        jTextArea = setUpArea();

        //center JTextArea
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panel.add(jTextArea, gbc);

        setLocation(p2);
        pack();
        setVisible(true);
    }

    private JTextArea setUpArea() {
        JTextArea jTextArea = new JTextArea();

        if (!propertyBundle.invertColors()) {
            jTextArea.setBackground(Color.BLACK);
            jTextArea.setForeground(Color.WHITE);
        } else {
            jTextArea.setBackground(Color.WHITE);
            jTextArea.setForeground(Color.BLACK);
        }

        Font font = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, propertyBundle.getFontsize());
        jTextArea.setFont(font);

        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setColumns(propertyBundle.getColumns());
        jTextArea.setRows(propertyBundle.getRows());
        jTextArea.setText(app.getText());
        return jTextArea;
    }

    public JTextArea getJTextArea() {
        return jTextArea;
    }

    @Override
    public void run() {
        showFrame();
    }
}
