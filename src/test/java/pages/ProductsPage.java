package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends BasePage {

    // ===== Existing locators =====
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartIcon = By.className("shopping_cart_link");

    private By addToCartButton(String productName) {
        return By.xpath(
                "//div[text()='" + productName + "']" +
                "/ancestor::div[@class='inventory_item']//button"
        );
    }

    // ===== Sorting locators =====
    private final By sortDropdown = By.className("product_sort_container");
    private final By productPrices = By.className("inventory_item_price");
    private final By productNames = By.className("inventory_item_name");

    // ===== Existing actions =====
    public void addProductToCart(String productName) {
        click(addToCartButton(productName));
    }

    public void verifyCartBadgeCount(String expected) {
        Assert.assertEquals(
                getText(cartBadge),
                expected,
                "Cart badge count is incorrect"
        );
    }

    public void clickCartIcon() {
        click(cartIcon);
    }

    public void verifyProductsPageDisplayed() {
        Assert.assertTrue(
                getCurrentUrl().contains("inventory"),
                "Not on Products page"
        );
    }

    // ===== Sorting actions =====
    public void selectSortOption(String sortOption) {
       Select select = new Select(waitForVisible(sortDropdown));
        select.selectByVisibleText(sortOption);
    }

    // ===== Data getters =====
    private List<Double> getProductPrices() {
        List<WebElement> elements = driver.findElements(productPrices);
        List<Double> prices = new ArrayList<>();

        for (WebElement e : elements) {
            prices.add(Double.parseDouble(e.getText().replace("$", "")));
        }
        return prices;
    }

    private List<String> getProductNames() {
        List<WebElement> elements = driver.findElements(productNames);
        List<String> names = new ArrayList<>();

        for (WebElement e : elements) {
            names.add(e.getText());
        }
        return names;
    }

    // ===== Validations =====
    public boolean isPriceSortedLowToHigh() {
        List<Double> actual = getProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        return actual.equals(expected);
    }

    public boolean isPriceSortedHighToLow() {
        List<Double> actual = getProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        return actual.equals(expected);
    }

    public boolean isNameSortedAToZ() {
        List<String> actual = getProductNames();
        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        return actual.equals(expected);
    }
}
