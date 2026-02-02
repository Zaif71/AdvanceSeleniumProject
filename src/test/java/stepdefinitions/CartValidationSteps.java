package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductsPage;

public class CartValidationSteps {

    CartPage cartPage = new CartPage();
    ProductsPage productsPage = new ProductsPage();

    @And("user navigates to cart page")
    public void user_navigates_to_cart_page() {
        productsPage.clickCartIcon();
    }

    @Then("product name should be {string}")
    public void product_name_should_be(String expectedProductName) {
        String actualProductName = cartPage.getProductName();
        Assert.assertEquals(
                actualProductName,
                expectedProductName,
                "Product name mismatch in cart"
        );
    }

    @Then("product price should be {string}")
    public void product_price_should_be(String expectedPrice) {
        String actualPrice = cartPage.getProductPrice();
        Assert.assertEquals(
                actualPrice,
                expectedPrice,
                "Product price mismatch in cart"
        );
    }

    @Then("product quantity should be {string}")
    public void product_quantity_should_be(String expectedQuantity) {
        String actualQuantity = cartPage.getProductQuantity();
        Assert.assertEquals(
                actualQuantity,
                expectedQuantity,
                "Product quantity mismatch in cart"
        );
    }
}
