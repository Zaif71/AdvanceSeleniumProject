package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.LogContext;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Hook {

    @Before
    public void setUp(Scenario scenario) {

        String env = System.getProperty("env", "qa");
        System.setProperty("incognito", "true");

        ConfigReader.loadConfig(env);
        DriverFactory.initDriver();

        try {
            Path source = Path.of("src/test/resources/environment.properties");
            Path target = Path.of("target/allure-results/environment.properties");
            Files.createDirectories(target.getParent());
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ignored) {}

        // Structured logging
        LogContext.init(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed() && DriverFactory.getDriver() != null) {
            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            io.qameta.allure.Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );
        }

        LogContext.clear();
        DriverFactory.quitDriver();
    }
}
