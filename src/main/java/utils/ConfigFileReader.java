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
        String propFilePath = "configs/config.properties";
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
            throw new RuntimeException("config.properties not found at " + propFilePath);
        }
    }

    public String getAppUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("url not specified in the config.properties file.");
        }
    }
}