package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("user is on SauceDemo login page")
    public void user_is_on_sauce_demo_login_page() {
        DriverFactory.getDriver()
                .get(ConfigReader.get("baseUrl"));
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("login outcome should be {string}")
    public void login_outcome_should_be(String result) {

        if (result.equalsIgnoreCase("success")) {
            loginPage.verifyLoginSuccess();
        } else {
            loginPage.verifyLoginFailure();
        }
    }
}
