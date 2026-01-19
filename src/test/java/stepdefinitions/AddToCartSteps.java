package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.util.Map;

public class AddToCartSteps {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @When("user adds {string} to the cart")
    public void user_adds_to_the_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Then("cart badge count should be {string}")
    public void cart_badge_count_should_be(String count) {
        productsPage.verifyCartBadgeCount(count);
    }

    @When("user navigates to cart")
    public void user_navigates_to_cart() {
        productsPage.clickCartIcon();
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.clickCheckout();
    }

    @When("user enters checkout details")
    public void user_enters_checkout_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        checkoutInformationPage.fillCheckoutDetails(
                data.get("firstName"),
                data.get("lastName"),
                data.get("zipCode")
        );

        checkoutInformationPage.clickContinue();
    }

    @When("user completes the checkout")
    public void user_completes_the_checkout() {
        checkoutOverviewPage.clickFinish();
    }

    @Then("checkout should be successful")
    public void checkout_should_be_successful() {
        checkoutCompletePage.verifyOrderSuccess();
    }
}
