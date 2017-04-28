package sk.tomas.sstp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Tomas Pachnik on 27-Apr-17.
 */
public class Utils {

    public static Properties loadProperties(String path) throws IOException {
        Properties properties = new Properties();
        InputStream input;
        input = new FileInputStream(path);
        properties.load(input);
        input.close();
        return properties;
    }

}
