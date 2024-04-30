package org.eat.tests;

import org.eat.base.WebDriverFactory;
import org.eat.base.BaseTestProject;
import org.testng.Assert;
import org.testng.annotations.*;
public class testProject extends BaseTestProject {
    @Test( dataProvider = "loginDataInvalid",groups = {"smoke"},priority = 7)
    public void logInWithInvalidData(String username, String password) {
        navP.toLoginPage();
        logP.SignInWith(username, password);
        boolean result = logP.verifyInvalidCredentialsErrorMessage();
        Assert.assertTrue(result);
    }
    @Test(groups = {"regression"},priority = 3)
    public void addToCartFromProduct() {
        shop.addToCartFromProductDetail();
        Assert.assertTrue(shop.ConfermingProductsAddtoCartFromProductPage());
    }
    @Test(groups = {"smoke"},priority = 1)
    public void addToCartFromHome() {
        shop.addToCartFromHomeP();
        Assert.assertTrue(shop.ConfermingProductsAddtoCart(), "Assertion conformed");
    }
    @Test(groups = {"regression"},priority = 2)
    public void returnToShoppingPageFromCart() {
        shop.returnToShoppingFromCart();
    }
    @Test(groups = {"smoke"},priority = 5)
    public void removeItemFromCart() {
        shop.removeItemFromCartPage();
        Assert.assertTrue(shop.confermEmptyCart());
    }
    @Test(groups = {"smoke"},priority = 4)
    public void removeItemFromHomePage() {
        shop.returnToShoppingFromCart();
        shop.removeItemFromHomePage();
    }
    @Test(groups = {"regression"},priority = 6)
    public void multipleItemToAdd() {
        shop.addingMultipleItems();
        Assert.assertTrue(shop.confermingCheckout());
    }
    @AfterClass(groups = {"smoke","regression"})
    public void cleanUP () {
        WebDriverFactory.getInstance().quitDriver();
    }
}

