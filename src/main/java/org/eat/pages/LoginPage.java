package org.eat.pages;

import org.eat.base.CustomDriver;
import org.openqa.selenium.WebDriver;
public class LoginPage extends CustomDriver {
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public WebDriver driver;
    private String MY_ACCOUNT_DROP_LIST= "xpath=>//span[text()='My Account']";
    private String LOGIN_PAGE ="linkText=>Login";
    private String EMAIL_FIELD = "id=>input-email";
    private String PASSWORD_FIELD = "id=>input-password";
    private String LOGIN_BUTTON = "xpath=>//input[@value='Login']";//"cssSelector=>input[value='Login']";
    private String LOG_OUT = "xpath=>//a[@class='menu-list-link bg-transparent-lightblue radius-s'and@title='Sign Out'] ";
    private String INVALID_CREDENTIALS_ERROR_MESSAGE = "xpath=>//div[@class='alert alert-danger alert-dismissible']";
    public void SignInWith(String username, String password) {
        clickWhenReady(MY_ACCOUNT_DROP_LIST, "Navigating to login page",15); //5added
        clickElement(LOGIN_PAGE,"login page");
        sendData(EMAIL_FIELD, username, "Email Field");
        sendData(PASSWORD_FIELD, password, "Password Field");
        clickElement(LOGIN_BUTTON, "Login Button");
    }
    public boolean verifyInvalidCredentialsErrorMessage() {
        boolean elementPresent = isElementPresent(INVALID_CREDENTIALS_ERROR_MESSAGE,
                "invalid credentail error message");
        return (elementPresent );
    }
    public void signOut(){
       clickElement(LOG_OUT, "Log out");

    }
}