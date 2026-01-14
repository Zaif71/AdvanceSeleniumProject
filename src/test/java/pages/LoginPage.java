package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.cssSelector("h3[data-test='error']");

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

    // -------- STATE METHODS (NO ASSERTIONS) --------

    public boolean isLoginSuccessful() {
        return getCurrentUrl().contains("inventory");
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public String getErrorMessageText() {
        return getText(errorMessage);
    }
}
