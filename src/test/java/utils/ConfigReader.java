package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadConfig() {
        try {
            properties = new Properties();
            FileInputStream fis =
                    new FileInputStream("src/test/resources/config/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties file");
        }
    }


    public static String get(String key) {
        String env = System.getProperty("env", "qa");
        return properties.getProperty(env + "." + key);
    }

}
