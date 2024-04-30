package org.eat.base;

import org.eat.pages.LoginPage;
import org.eat.pages.NavigationPage;
import org.eat.pages.shoppingPage;
import org.eat.utilities.Constants;
import org.eat.utilities.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
public class BaseTestProject {
    public WebDriver driver;
    public LoginPage logP ;
    public NavigationPage navP;
    public shoppingPage shop;
    @BeforeClass(groups = {"smoke","regression"})
    public void setUp () throws Exception {
        driver= WebDriverFactory.getInstance().getDriver("chrome");
        driver.get(Constants.TEST_URL);
        // ExcelUtility.setExcelFile(constants.excelFilePath,"jenkins");
        ExcelUtility.setExcelFile(Constants.EXCEL_FILEPATH2,"projectData");
        logP=new LoginPage(driver);
        navP=new NavigationPage(driver);
        shop=new shoppingPage(driver);
    }
    @Test(dataProvider = "loginData",groups = {"smoke"})
    public void aaalogInWithValidData (String username,String password) {
        logP.SignInWith(username,password);
        boolean result=navP.isUserLoggedIn();
        Assert.assertTrue(result);
    }
    @DataProvider(name="loginData")
    public Object[][] loginTestData(){
        Object[][] testData= ExcelUtility.getTestData("validData");
        return testData;
    }
    @DataProvider(name="loginDataInvalid")
    public Object[][] loginTestInvalidData(){
        Object[][] testData= ExcelUtility.getTestData("invalidData");
        return testData;
    }
}
