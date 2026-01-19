package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By checkoutBtn = By.id("checkout");

    public void clickCheckout() {
        click(checkoutBtn);
    }
}
