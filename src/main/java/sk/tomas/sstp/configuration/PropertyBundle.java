package sk.tomas.sstp.configuration;

import sk.tomas.sstp.util.Utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Tomas Pachnik on 28-Apr-17.
 */

public class PropertyBundle {

    private Properties properties;

    PropertyBundle(String path) {
        try {
            properties = Utils.loadProperties(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getFontsize() {
        return Integer.parseInt(properties.getProperty(PropertyEnum.FONT_SIZE.getName()));
    }

    public int getColumns() {
        return Integer.parseInt(properties.getProperty(PropertyEnum.COLUMNS.getName()));
    }

    public int getRows() {
        return Integer.parseInt(properties.getProperty(PropertyEnum.ROWS.getName()));
    }

    public boolean invertColors() {
        return Boolean.parseBoolean(properties.getProperty(PropertyEnum.INVERT_COLORS.getName()));
    }

}
