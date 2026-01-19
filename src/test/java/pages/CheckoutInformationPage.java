package pages;

import org.openqa.selenium.By;

public class CheckoutInformationPage extends BasePage {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput  = By.id("last-name");
    private final By zipCodeInput   = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public void fillCheckoutDetails(String firstName, String lastName, String zipCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(zipCodeInput, zipCode);
    }

    public void clickContinue() {
        click(continueButton);
    }
}
