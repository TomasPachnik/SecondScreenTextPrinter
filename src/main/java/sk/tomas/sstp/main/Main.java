package sk.tomas.sstp.main;

import org.apache.log4j.Logger;
import sk.tomas.servant.core.Core;
import sk.tomas.servant.core.impl.CoreImpl;
import sk.tomas.servant.exception.BeanNotFoundException;
import sk.tomas.sstp.configuration.Configuration;

/**
 * Created by tomas on 4/24/17.
 */
public class Main {

    private final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws BeanNotFoundException {

        Core core = new CoreImpl(Configuration.class);
        ((App) core.getByName("app")).initialize();
        logger.info("App started");

    }

}
