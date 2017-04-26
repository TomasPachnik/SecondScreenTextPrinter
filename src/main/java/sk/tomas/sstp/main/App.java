package sk.tomas.sstp.main;

import sk.tomas.sstp.gui.ControlPanel;
import sk.tomas.sstp.gui.SecondScreenFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tomas Pachnik on 26-Apr-17.
 */
public class App {

    public void twoscreen() {
        Point p1 = null;
        Point p2 = null;
        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment ().getScreenDevices()) {
            if (p1 == null) {
                p1 = gd.getDefaultConfiguration().getBounds().getLocation();
            } else if (p2 == null) {
                p2 = gd.getDefaultConfiguration().getBounds().getLocation();
            }
        }
        if (p2 == null) {
            p2 = p1;
        }

        ControlPanel frame1 = new ControlPanel();
        SecondScreenFrame frame2 = new SecondScreenFrame();

        createFrameAtLocation(p1, frame1.showFrame());
        createFrameAtLocation(p2, frame2.showFrame());
    }

    private void createFrameAtLocation(Point p, JFrame frame) {
        frame.setLocation(p);
        frame.pack();
        frame.setVisible(true);
    }

}
