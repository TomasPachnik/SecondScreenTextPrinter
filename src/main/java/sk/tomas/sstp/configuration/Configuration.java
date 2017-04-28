package sk.tomas.sstp.configuration;

import org.apache.log4j.Logger;
import sk.tomas.servant.annotation.Bean;
import sk.tomas.servant.annotation.Config;
import sk.tomas.sstp.gui.ControlPanel;
import sk.tomas.sstp.gui.SecondScreenFrame;
import sk.tomas.sstp.main.App;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Tomas Pachnik on 27-Apr-17.
 */

@Config
public class Configuration {

    private final static Logger logger = Logger.getLogger(Configuration.class);

    @Bean
    public App app() {
        return new App();
    }

    @Bean
    public ControlPanel controlPanel() {
        return new ControlPanel();
    }

    @Bean
    public SecondScreenFrame secondScreenFrame() {
        return new SecondScreenFrame();
    }

    @Bean
    public PropertyBundle propertyBundle() {
        return new PropertyBundle("config.properties");
    }

    @Bean
    public Point p1() {
        return getPoint(0);

    }

    @Bean
    public Point p2() {
        return getPoint(1);
    }

    private Point getPoint(int screenNumber) {
        GraphicsDevice gd = null;
        try {
            gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[screenNumber];
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Screen with number " + screenNumber + " not found!", e);
        }
        return gd != null ? gd.getDefaultConfiguration().getBounds().getLocation() : null;
    }

}
