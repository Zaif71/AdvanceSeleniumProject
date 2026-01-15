package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    // Cart badge
    private final By cartBadge = By.className("shopping_cart_badge");

    // Dynamic locator for Add to Cart button
    private By addToCartButton(String productName) {
        return By.xpath(
                "//div[text()='" + productName + "']" +
                        "/ancestor::div[@class='inventory_item']//button"
        );
    }

    // Actions
    public void addProductToCart(String productName) {
        click(addToCartButton(productName));
    }

    // Assertions (POM level)
    public void verifyCartBadgeCount(String expectedCount) {
        Assert.assertEquals(
                getText(cartBadge),
                expectedCount,
                "Cart badge count is incorrect"
        );
    }
}
