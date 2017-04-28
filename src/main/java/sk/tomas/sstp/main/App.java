package sk.tomas.sstp.main;

import sk.tomas.servant.annotation.Autowired;
import sk.tomas.sstp.gui.ControlPanel;
import sk.tomas.sstp.gui.SecondScreenFrame;

import java.awt.*;

/**
 * Created by Tomas Pachnik on 26-Apr-17.
 */
public class App {

    @Autowired
    private ControlPanel controlPanel;
    @Autowired
    private SecondScreenFrame secondScreenFrame;

    private String text;

    public App() {
        this.text = "";
    }

    void initialize() {
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

        controlPanel.setP(p1);
        secondScreenFrame.setP(p2);

        Thread thread1 = new Thread(controlPanel);
        Thread thread2 = new Thread(secondScreenFrame);

        thread1.start();
        thread2.start();

    }

    public String getText() {
        return text;
    }

    public void updateText(String text) {
        this.text = text;
        secondScreenFrame.getJTextArea().setText(text);
    }
}
