package org.eat.pages;

import org.eat.base.CustomDriver;
import org.openqa.selenium.WebDriver;
public class shoppingPage extends CustomDriver {
    public shoppingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    private String ADD_TO_CART_FROM_HOME_PAGE = "xpath=>//div[@id='content']//div[1]//div[1]//div[3]//button[1]";
    private String CONFERMING_PRODUCTS_ADDED_TO_CART = "xpath=>//div[@class='alert alert-success alert-dismissible']";
    private String CLICK_ON_PRODUCT ="xpath=>//img[@title='iPhone'and@class='img-responsive']";
    private String ADD_TO_CART_FROM_PRODUCT_DETAIL ="xpath=>//button[@id='button-cart']";
    private String CONFERM_ITEM_ADDED_TO_CART ="xpath=>//ul[@class='breadcrumb']//following-sibling::div[1]";
    private String CART_ICON ="xpath=>//span[text()='Shopping Cart']";
    private String NAVIGATE_TO_HOME_PAGE ="linkText=>Qafox.com";
    private String REMOVE_FROM_CART_PAGE = "xpath=>//button[@class='btn btn-danger']";
    private String CLICK_CART_ON_HOME_PAGE ="xpath=>//div[@id='cart']//button[@data-toggle='dropdown']";
    private String REMOVE_FROM_HOME_PAGE = "xpath=>//button[@title='Remove']";
    private String ADD_PRODUCT_1 = "xpath=>//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]/span";
    private String ADD_PRODUCT_2 = "xpath=>//*[@id='content']/div[2]/div[2]/div/div[3]/button[1]/span";
    private String CHECKOUT = "linkText=>Checkout";
    private String CONFERM_CHECKOUT_MESSAGE = "xpath=>//ul[@class='breadcrumb']//following-sibling::div[1]";
    private String MY_ACCOUNT_DROP_LIST= "xpath=>//span[text()='My Account']";
    private String LOGGING_OUT = "linkText=>Logout";
    private String CONFERM_CART_EMPTY_MESSAGE = "xpath=>//div[@id='content']//ancestor::p";
    private String CONTINUE_SHOPPING_BUTTON = "linkText=>Continue";
    public void addToCartFromHomeP() {
        clickWhenReady(ADD_TO_CART_FROM_HOME_PAGE,"item added from home page",8);
    }
    public boolean ConfermingProductsAddtoCart(){
        boolean result = isElementPresent(CONFERMING_PRODUCTS_ADDED_TO_CART, "Products successfully added to the cart");
        return result;
    }
    public void addToCartFromProductDetail() {
        clickWhenReady(CLICK_ON_PRODUCT,"item clicked for the next step",20);
        clickWhenReady(ADD_TO_CART_FROM_PRODUCT_DETAIL,"item added to cart from product detail",20);
    }
    public boolean ConfermingProductsAddtoCartFromProductPage(){
        boolean result = isElementPresent(CONFERM_ITEM_ADDED_TO_CART, "Products successfully added to the cart");
        return result;
    }
    public void returnToShoppingFromCart(){
        driver.navigate().refresh();
    }
    public void removeItemFromCartPage(){
        clickWhenReady(CART_ICON,"cart icon clicked to remove item",8);
        clickWhenReady(REMOVE_FROM_CART_PAGE,"remove product from cart page  ",10);
    }
    public void removeItemFromHomePage(){
        clickElement(CLICK_CART_ON_HOME_PAGE,"");
        clickWhenReady(REMOVE_FROM_HOME_PAGE,"remove item from home page  ",17);//5added
    }
    public void addingMultipleItems(){
        clickWhenReady(ADD_PRODUCT_1,"adding product 1 for checkout",16);//5added
        clickWhenReady(NAVIGATE_TO_HOME_PAGE,"",10);
        clickWhenReady(ADD_PRODUCT_2,"adding product 2 for checkout",9);
        clickWhenReady(CART_ICON,"clicked on cart icon for checkout items",8);
        clickWhenReady(CHECKOUT,"click on checkout button for checkout items ",8);
    }
    public boolean confermingCheckout(){
       boolean result=isElementPresent(CONFERM_CHECKOUT_MESSAGE,"Checkout successfully");
       clickElement(MY_ACCOUNT_DROP_LIST,"");
       clickElement(LOGGING_OUT,"");
       return result;
    }
    public boolean confermEmptyCart(){
        boolean result = isElementPresent(CONFERM_CART_EMPTY_MESSAGE, "");
        clickWhenReady(CONTINUE_SHOPPING_BUTTON,"Continue Shopping",10);
        return result;
    }
}