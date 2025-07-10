package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try {
            InputStream input = ClassLoader.getSystemResourceAsStream("config/config.properties");
            if (input == null) {
                throw new RuntimeException("Not found: config/config.properties");
            }
            props.load(input);
        } catch (IOException e) {
            System.out.println("Error reading config.properties: " + e.getMessage());
        }
    }

    public static String get(String key){
        return props.getProperty(key);
    }
}
