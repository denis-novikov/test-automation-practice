package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propFilePath = "configs/Config.properties";
        try {
            reader = new BufferedReader(new FileReader(propFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config.properties not found at " + propFilePath);
        }
    }

    public String getDriver() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) {
            return driverPath;
        } else {
            throw new RuntimeException("driverPath not specified in the Config.properties file.");
        }
    }

    public String getAppUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("url not specified in the Config.properties file.");
        }
    }
}