package sk.tomas.sstp.configuration;

import sk.tomas.servant.annotation.Bean;
import sk.tomas.servant.annotation.Config;
import sk.tomas.sstp.main.App;

/**
 * Created by Tomas Pachnik on 27-Apr-17.
 */

@Config
public class Configuration {

    @Bean
    public App app() {
        return new App();
    }
}
