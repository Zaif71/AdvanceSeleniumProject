package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Parameters({"browser", "env"})
    @BeforeClass
    public void setUp(String browser, String env) {
        System.setProperty("browser", browser);
        System.setProperty("env", env);
    }
}
