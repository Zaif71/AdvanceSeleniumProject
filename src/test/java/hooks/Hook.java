package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.DriverFactory;

import java.io.ByteArrayInputStream;

public class Hook {

    @Before
    public void setUp() {
        // Load configuration file
        ConfigReader.loadConfig();

        // Initialize WebDriver
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        // Take screenshot if scenario fails
        if (scenario.isFailed()) {
            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );
        }

        // Quit WebDriver
        DriverFactory.quitDriver();
    }
}
