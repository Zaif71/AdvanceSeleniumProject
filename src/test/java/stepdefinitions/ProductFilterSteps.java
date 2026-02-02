package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductsPage;

public class ProductFilterSteps {

    ProductsPage productsPage = new ProductsPage();

    @When("user sorts products by {string}")
    public void user_sorts_products_by(String sortOption) {
        productsPage.selectSortOption(sortOption);
    }

    @Then("products should be displayed in ascending price order")
    public void products_should_be_displayed_in_ascending_price_order() {
        Assert.assertTrue(
                productsPage.isPriceSortedLowToHigh(),
                "Products are not sorted by price low to high"
        );
    }

    @Then("products should be displayed in descending price order")
    public void products_should_be_displayed_in_descending_price_order() {
        Assert.assertTrue(
                productsPage.isPriceSortedHighToLow(),
                "Products are not sorted by price high to low"
        );
    }

    @Then("products should be displayed in alphabetical order")
    public void products_should_be_displayed_in_alphabetical_order() {
        Assert.assertTrue(
                productsPage.isNameSortedAToZ(),
                "Products are not sorted alphabetically A to Z"
        );
    }
}
