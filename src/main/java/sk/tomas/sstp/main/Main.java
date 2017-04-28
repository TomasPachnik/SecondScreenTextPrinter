package sk.tomas.sstp.main;

import sk.tomas.servant.core.Core;
import sk.tomas.servant.core.impl.CoreImpl;
import sk.tomas.servant.exception.BeanNotFoundException;
import sk.tomas.sstp.configuration.Configuration;
import sk.tomas.sstp.util.Utils;

import java.util.Properties;

/**
 * Created by tomas on 4/24/17.
 */
public class Main {

    public static void main(String[] args) throws BeanNotFoundException {

        Properties properties = Utils.loadProperties("config.properties");

        System.out.println(properties.getProperty("name"));

        Core core = new CoreImpl(Configuration.class);

        ((App) core.getByName("app")).initialize();

    }

}
