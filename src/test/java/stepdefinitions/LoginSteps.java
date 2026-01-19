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

    // ---------- Existing Step (UNCHANGED) ----------

    @Given("user is on SauceDemo login page")
    public void user_is_on_sauce_demo_login_page() {
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
    }

    // ---------- Existing Step (UNCHANGED) ----------
    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    // ---------- Existing Step (UNCHANGED) ----------
    @Then("login outcome should be {string}")
    public void login_outcome_should_be(String expectedResult) {

        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(
                    loginPage.isLoginSuccessful(),
                    "Expected login to be successful, but it failed"
            );
        } else {
            Assert.assertTrue(
                    loginPage.isErrorMessageDisplayed(),
                    "Expected error message to be displayed, but it was not"
            );

            String actualError = loginPage.getErrorMessageText();
            Assert.assertFalse(
                    actualError.isEmpty(),
                    "Error message text should not be empty"
            );
        }
    }



    // ---------- ✅ NEW STEP (ADDED FOR ADD TO CART / CHECKOUT) ----------
    @Given("user is logged in to SauceDemo")
    public void user_is_logged_in_to_saucedemo() {
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login failed in precondition step"
        );
    }
}
