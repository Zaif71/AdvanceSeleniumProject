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
    public void setUp(Scenario scenario) {

        // 1️⃣ Read environment (default = qa)
        String env = System.getProperty("env", "qa");

        // 2️⃣ Enable incognito mode (default = true)
        System.setProperty("incognito", "true");

        // 3️⃣ Load config based on environment
        ConfigReader.loadConfig(env);

        // 4️⃣ Initialize WebDriver
        DriverFactory.initDriver();

        // 5️⃣ Add scenario details to Allure
        Allure.parameter("Environment", env);
        Allure.parameter("Scenario", scenario.getName());
        Allure.parameter("Incognito", "true");
    }

    @After
    public void tearDown(Scenario scenario) {

        // 6️⃣ Attach screenshot on failure
        if (scenario.isFailed() && DriverFactory.getDriver() != null) {

            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );
        }

        // 7️⃣ Quit browser safely
        DriverFactory.quitDriver();
    }
}
