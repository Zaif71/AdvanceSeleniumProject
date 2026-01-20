package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.cssSelector("[data-test='error']");

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public boolean isLoginSuccessful() {
        return getCurrentUrl().contains("inventory");
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMsg);
    }

    public String getErrorMessageText() {
        return getText(errorMsg);
    }
    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginBtn);
    }
}
