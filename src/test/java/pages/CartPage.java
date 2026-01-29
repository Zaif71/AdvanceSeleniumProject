package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class CartPage {

    WebDriver driver = DriverFactory.getDriver();

    // Locators
    private By productNameLocator = By.xpath("//div[@class='inventory_item_name']");
    private By productPriceLocator = By.xpath("//div[@class='inventory_item_price']");
    private By productQuantityLocator = By.xpath("//div[@class='cart_quantity']");
    private final By checkoutBtn = By.id("checkout");

    // Methods
    public String getProductName() {
        WebElement productNameElement = driver.findElement(productNameLocator);
        return productNameElement.getText();
    }

    public String getProductPrice() {
        WebElement productPriceElement = driver.findElement(productPriceLocator);
        return productPriceElement.getText();
    }

    public String getProductQuantity() {
        WebElement productQuantityElement = driver.findElement(productQuantityLocator);
        return productQuantityElement.getText();
    }

    public boolean isProductDisplayedInCart(String productName) {
        try {
            By productLocator = By.xpath("//div[contains(text(), '" + productName + "')]");
            return driver.findElement(productLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProductFromCart() {
        By removeButtonLocator = By.xpath("//button[contains(text(), 'Remove')]");
        driver.findElement(removeButtonLocator).click();
    }

    public int getCartItemCount() {
        try {
            By cartItemsLocator = By.xpath("//div[@class='cart_item']");
            return driver.findElements(cartItemsLocator).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
