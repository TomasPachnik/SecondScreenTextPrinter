package sk.tomas.sstp.main;

import sk.tomas.sstp.gui.ControlPanel;
import sk.tomas.sstp.gui.SecondScreenFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tomas Pachnik on 26-Apr-17.
 */
public class App {

    private ControlPanel frame1;
    private SecondScreenFrame frame2;
    private String text;

    App() {
        this.text = "random text";
        frame1 = new ControlPanel(this);
        frame2 = new SecondScreenFrame(this);
    }

    void twoscreen() {
        Point p1 = null;
        Point p2 = null;
        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            if (p1 == null) {
                p1 = gd.getDefaultConfiguration().getBounds().getLocation();
            } else if (p2 == null) {
                p2 = gd.getDefaultConfiguration().getBounds().getLocation();
            }
        }
        if (p2 == null) {
            p2 = p1;
        }

        ControlPanel frame1 = new ControlPanel(this);
        SecondScreenFrame frame2 = new SecondScreenFrame(this);

        createFrameAtLocation(p1, frame1.showFrame());
        createFrameAtLocation(p2, frame2.showFrame());

    }

    private void createFrameAtLocation(Point p, JFrame frame) {
        frame.setLocation(p);
        frame.pack();
        frame.setVisible(true);
    }

    public ControlPanel getFrame1() {
        return frame1;
    }

    public SecondScreenFrame getFrame2() {
        return frame2;
    }

    public String getText() {
        return text;
    }

    public void updateText(String text) {
        this.text = text;
        frame2.getLabel().setText(text);
        System.out.println(text + " - " + frame2.getLabel().getText());
    }
}
