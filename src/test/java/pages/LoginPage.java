package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    // Locators
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    // Actions
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // ===== Assertions (POM-level) =====

    public void verifyLoginSuccess() {
        Assert.assertTrue(
                getCurrentUrl().contains("inventory"),
                "Login failed: User is not redirected to Products page"
        );
    }

    public void verifyLoginFailure() {
        Assert.assertTrue(
                isDisplayed(errorMessage),
                "Login failure expected but error message not displayed"
        );
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
