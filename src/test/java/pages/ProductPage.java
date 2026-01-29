package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class ProductPage {

    WebDriver driver = DriverFactory.getDriver();

    // Locators
    private By cartIconLocator = By.xpath("//a[@class='shopping_cart_link']");
    private By cartBadgeLocator = By.xpath("//span[@class='shopping_cart_badge']");

    // Methods
    public void addProductToCart(String productName) {
        By addToCartButton = By.xpath(
                "//div[contains(text(), '" + productName + "')]/ancestor::div[@class='inventory_item']//button[contains(text(), 'Add to cart')]"
        );
        try {
            WebElement button = driver.findElement(addToCartButton);
            button.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to add product: " + productName + " to cart", e);
        }
    }

    public void clickCartIcon() {
        driver.findElement(cartIconLocator).click();
    }

    public String getCartBadgeCount() {
        try {
            return driver.findElement(cartBadgeLocator).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public boolean isCartBadgeDisplayed() {
        try {
            return driver.findElement(cartBadgeLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}