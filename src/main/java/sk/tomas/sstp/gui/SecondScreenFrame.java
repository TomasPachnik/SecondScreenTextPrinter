package sk.tomas.sstp.gui;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/**
 * Created by Tomas Pachnik on 25-Apr-17.
 */
public class SecondScreenFrame extends JFrame {

    public SecondScreenFrame() {
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

        JTextPane textPane = new JTextPane();

        //center JTextPane
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        Font font = new Font(Font.SANS_SERIF, 3, 25);
        textPane.setFont(font);

        textPane.setText("random text");

        panel.add(textPane, gbc);

        return this;
    }

}
