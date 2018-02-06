package model.data.properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:global.properties")
public interface Environments extends Config {
    @Key("environment")
    String getEnvironment();
}
