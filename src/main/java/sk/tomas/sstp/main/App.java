package sk.tomas.sstp.main;

import sk.tomas.sstp.gui.ControlPanel;
import sk.tomas.sstp.gui.SecondScreenFrame;

import java.awt.*;

/**
 * Created by Tomas Pachnik on 26-Apr-17.
 */
public class App {

    private ControlPanel frame1;
    private SecondScreenFrame frame2;
    private String text;

    App() {
        this.text = "";
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

        frame1 = new ControlPanel(this, p1);
        frame2 = new SecondScreenFrame(this, p2);

        Thread thread1 = new Thread(frame1);
        Thread thread2 = new Thread(frame2);

        thread1.start();
        thread2.start();

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
    }
}
