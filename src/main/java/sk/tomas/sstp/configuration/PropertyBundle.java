package sk.tomas.sstp.configuration;

import org.apache.log4j.Logger;
import sk.tomas.sstp.util.Utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Tomas Pachnik on 28-Apr-17.
 */

public class PropertyBundle {
    private final static Logger logger = Logger.getLogger(PropertyBundle.class);

    private Properties properties;

    PropertyBundle(String path) {
        try {
            properties = Utils.loadProperties(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getFontsize() {
        return getInt(PropertyEnum.FONT_SIZE.getName());
    }

    public int getColumns() {
        return getInt(PropertyEnum.COLUMNS.getName());
    }

    public int getRows() {
        return getInt(PropertyEnum.ROWS.getName());
    }

    public boolean invertColors() {
        return Boolean.parseBoolean(PropertyEnum.INVERT_COLORS.getName());
    }

    private int getInt(String key) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (NumberFormatException e) {
            String message = "Error parsing " + key + ", value is: " + properties.getProperty(key);
            logger.error(message, e);
            Utils.showErrorAndExit(MessagesEnum.CONFIGURATION_ERROR.getText() + "\n" + message);
        }
        return -1;
    }

}
