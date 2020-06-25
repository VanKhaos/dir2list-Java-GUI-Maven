package de.thunderfrog.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadPropertie(){
        Properties properties = new Properties();
        try {
            InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return properties;
    }

}
