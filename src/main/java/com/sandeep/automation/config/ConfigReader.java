package com.sandeep.automation.config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance;
    private final Properties properties = new Properties();

    private ConfigReader() {
        try (InputStream in = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration", e);
        }
    }

    public static synchronized ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    public String getProperty(String key, String defaultValue) {
    return properties.getProperty(key, defaultValue);
}

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

public int getInt(String key) {
    return Integer.parseInt(getProperty(key));
}

public boolean getBoolean(String key) {
    return Boolean.parseBoolean(getProperty(key));
}
    
}
