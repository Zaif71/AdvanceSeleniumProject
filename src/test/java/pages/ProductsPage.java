package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartIcon = By.className("shopping_cart_link");

    private By addToCartButton(String productName) {
        return By.xpath(
                "//div[text()='" + productName + "']" +
                        "/ancestor::div[@class='inventory_item']//button"
        );
    }

    public void addProductToCart(String productName) {
        click(addToCartButton(productName));
    }

    public void verifyCartBadgeCount(String expected) {
        Assert.assertEquals(getText(cartBadge), expected,
                "Cart badge count is incorrect");
    }

    public void clickCartIcon() {
        click(cartIcon);
    }

    public void verifyProductsPageDisplayed() {
        Assert.assertTrue(getCurrentUrl().contains("inventory"),
                "Not on Products page");
    }
}
