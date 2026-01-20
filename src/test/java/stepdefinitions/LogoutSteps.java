package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.MenuPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LogoutSteps {

    MenuPage menuPage = new MenuPage();
    LoginPage loginPage = new LoginPage();

    @When("user clicks on logout")
    public void user_clicks_on_logout() {
        menuPage.logout();
    }

    @Then("user should be redirected to login page")
   public void user_should_be_redirected_to_login_page() {

    String actualUrl = DriverFactory.getDriver()
            .getCurrentUrl()
            .replaceAll("/$", "");   // removes trailing /

    String expectedUrl = ConfigReader.get("baseUrl")
            .replaceAll("/$", "");

    Assert.assertEquals(
            actualUrl,
            expectedUrl,
            "User not redirected to SauceDemo login page"
    );
    }

    @Then("login page should be displayed")
    public void login_page_should_be_displayed() {
        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Login page is not displayed"
        );
    }
}
