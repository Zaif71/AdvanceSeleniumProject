package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize driver
    public static void initDriver() {

        if (driver.get() == null) {

            // Read incognito flag (default = false)
            String incognito = System.getProperty("incognito", "false");

            ChromeOptions options = new ChromeOptions();

            // ✅ Enable Incognito if flag is true
            if (incognito.equalsIgnoreCase("true")) {
                options.addArguments("--incognito");
            }

            // Recommended options
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");

            WebDriver webDriver = new ChromeDriver(options);

            webDriver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            driver.set(webDriver);
        }
    }

    // Get driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit driver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
