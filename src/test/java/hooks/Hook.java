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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Hook {

    @Before
    public void setUp(Scenario scenario) {

        // 1️⃣ Read environment (default = qa)
        String env = System.getProperty("env", "qa");

        // 2️⃣ Enable incognito mode
        System.setProperty("incognito", "true");

        // 3️⃣ Load config based on environment
        ConfigReader.loadConfig(env);

        // 4️⃣ Initialize WebDriver
        DriverFactory.initDriver();

        // 5️⃣ Copy environment.properties for Allure
        try {
            Path source = Path.of("src/test/resources/environment.properties");
            Path target = Path.of("target/allure-results/environment.properties");
            Files.createDirectories(target.getParent());
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("⚠️ Unable to copy environment.properties to Allure results");
        }

        // 6️⃣ Optional: Add runtime parameters (nice to have)
        Allure.parameter("Scenario", scenario.getName());
        Allure.parameter("Environment", env);
        Allure.parameter("Incognito", "true");
    }

    @After
    public void tearDown(Scenario scenario) {

        // 7️⃣ Attach screenshot on failure
        if (scenario.isFailed() && DriverFactory.getDriver() != null) {
            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );
        }

        // 8️⃣ Quit browser safely
        DriverFactory.quitDriver();
    }
}
