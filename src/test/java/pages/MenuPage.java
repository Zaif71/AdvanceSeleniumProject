package pages;

import org.openqa.selenium.By;
import utils.DriverFactory;

public class MenuPage {

    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public void logout() {
        DriverFactory.getDriver().findElement(menuButton).click();
        DriverFactory.getDriver().findElement(logoutLink).click();
    }
}
