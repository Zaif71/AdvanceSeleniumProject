package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        if (driver.get() == null) {

            // 🔹 Read flags
            String incognito = System.getProperty("incognito", "false");
            String headless = System.getProperty("headless", "false");

            ChromeOptions options = new ChromeOptions();

            // 🔹 Incognito (local / CI)
            if (incognito.equalsIgnoreCase("true")) {
                options.addArguments("--incognito");
            }

            // 🔹 Headless (MANDATORY for CI)
            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-gpu");
            }

            // 🔹 REQUIRED for Linux CI
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            // 🔹 Safe options
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");

            WebDriver webDriver = new ChromeDriver(options);

            webDriver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            driver.set(webDriver);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
