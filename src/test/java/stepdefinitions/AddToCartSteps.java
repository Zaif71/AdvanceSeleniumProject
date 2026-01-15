package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class AddToCartSteps {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Given("user is logged in to SauceDemo")
    public void user_is_logged_in_to_saucedemo() {
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        loginPage.isLoginSuccessful();
    }

    @When("user adds {string} to the cart")
    public void user_adds_product_to_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Then("cart badge count should be {string}")
    public void cart_badge_count_should_be(String count) {
        productsPage.verifyCartBadgeCount(count);
    }
}
