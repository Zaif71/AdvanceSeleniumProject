package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on SauceDemo login page")
    public void user_is_on_sauce_demo_login_page() {
        DriverFactory.getDriver()
                .get(ConfigReader.get("baseUrl"));
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("login outcome should be {string}")
    public void login_outcome_should_be(String expectedResult) {

        if (expectedResult.equalsIgnoreCase("success")) {

            // ✅ PASS / FAIL decision here
            Assert.assertTrue(
                    loginPage.isLoginSuccessful(),
                    "Expected login to be successful, but it failed"
            );

        } else {

            // ✅ PASS / FAIL decision here
            Assert.assertTrue(
                    loginPage.isErrorMessageDisplayed(),
                    "Expected error message to be displayed, but it was not"
            );

            // (Optional but powerful validation)
            String actualError = loginPage.getErrorMessageText();
            Assert.assertFalse(
                    actualError.isEmpty(),
                    "Error message text should not be empty"
            );
        }
    }
}
