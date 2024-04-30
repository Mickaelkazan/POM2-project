package org.eat.pages;

import org.eat.base.CustomDriver;
import org.eat.utilities.Constants;
import org.openqa.selenium.WebDriver;
public class NavigationPage extends CustomDriver {
    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public WebDriver driver;
    private String CONFERM_LOGGEDIN = "linkText=>Edit your account information";
    private String NAVIGATE_TO_HOME_PAGE ="linkText=>Qafox.com";
    public void toLoginPage() {
        driver.get(Constants.TEST_URL);
    }
    public boolean isUserLoggedIn() {
        boolean result = isElementPresent(CONFERM_LOGGEDIN , "user successfully logged in");
        clickElement(NAVIGATE_TO_HOME_PAGE, "");
        return result;
    }
}