package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String getValue(String key) throws IOException {
        return properties.getProperty(key);
    }
}
