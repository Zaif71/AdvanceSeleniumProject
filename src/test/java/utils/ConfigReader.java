package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    public static void loadConfig(String env) {
        try {
            String fileName = "config/config-" + env + ".properties";
            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (is == null) {
                throw new RuntimeException("Failed to load config for env: " + env);
            }

            properties.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config for env: " + env, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
