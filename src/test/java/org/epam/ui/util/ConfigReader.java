package org.epam.ui.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static String config = System.getProperty("env");

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/" + config + ".properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getData(String key){
        return properties.getProperty(key);
    }
}
