package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage {

    private final By successMsg = By.className("complete-header");
    private final By backHomeBtn = By.id("back-to-products");

    public void verifyOrderSuccess() {
        Assert.assertTrue(isDisplayed(successMsg),
                "Order was not completed");
    }

    public void clickBackHome() {
        click(backHomeBtn);
    }
}
