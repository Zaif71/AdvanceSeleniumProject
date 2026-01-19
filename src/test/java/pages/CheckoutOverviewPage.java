package pages;

import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {

    private final By finishButton = By.id("finish");

    public void clickFinish() {
        click(finishButton);
    }
}
