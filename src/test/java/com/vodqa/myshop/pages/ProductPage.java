package com.vodqa.myshop.pages;

import com.vodqa.myshop.helpers.ElementHelpers;
import com.vodqa.myshop.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class ProductPage extends BasePage<ProductPage> {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private By ddSize=By.id("size");
    private By ddColor=By.id("color");
    private By lblPrice=By.id("price");
    private By bBuy=By.id("buyButton");

    //Page Objects
    private Select getSize(){
        return ElementHelpers.getDropDownSaflyBy(driver,ddSize);
    }
    private Select getColor(){
        return ElementHelpers.getDropDownSaflyBy(driver,ddColor);
    }
    private WebElement getBuyButton(){
        return ElementHelpers.getWebElementSaflyBy(driver,bBuy);
    }
    private WebElement getPriceLabel(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblPrice);
    }

    //Interactions
    public ProductPage setSize(String size){
        getSize().selectByVisibleText(size);
        return this;
    }
    public ProductPage setColor(String color){
        getColor().selectByVisibleText(color);
        return this;
    }

    public ShippingInfoPage buy(){
        ElementHelpers.waitForVisibilityOfElement(driver,getBuyButton());
        getBuyButton().click();
        return PageFactory.getPage(driver,ShippingInfoPage.class);
    }

    public String getPrice(String price){
        ElementHelpers.waitForTextSetForElement(driver, getPriceLabel());
        return getPriceLabel().getText();
    }
}
