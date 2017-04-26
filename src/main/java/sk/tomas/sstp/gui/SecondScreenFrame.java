package sk.tomas.sstp.gui;

import sk.tomas.sstp.main.App;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tomas Pachnik on 25-Apr-17.
 */
public class SecondScreenFrame extends JFrame{

    private App app;
    private JLabel label;

    public SecondScreenFrame(App app) {
        this.app = app;
        this.label = new JLabel();
    }

    public JFrame showFrame() {
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

        //center JLabel
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Font font = new Font(Font.SANS_SERIF, 3, 25);

        label.setText(app.getText());

        panel.add(label, gbc);

        return this;
    }

    public JLabel getLabel() {
        return label;
    }
}
