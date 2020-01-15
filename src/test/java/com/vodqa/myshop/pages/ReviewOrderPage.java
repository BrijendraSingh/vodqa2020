package com.vodqa.myshop.pages;

import com.vodqa.myshop.helpers.ElementHelpers;
import com.vodqa.myshop.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewOrderPage extends BasePage<ReviewOrderPage> {
    public ReviewOrderPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By bPlace=By.id("place");
    By lblItems=By.id("items");
    By lblShipping=By.id("shipping");
    By lblGiftPacking=By.id("gift");
    By lblTotalBeforeTax=By.id("tbt");
    By lblTax=By.id("tax");
    By lblTotal=By.id("total");

    //Elements
    private WebElement getPlaceButton(){
        return ElementHelpers.getWebElementSaflyBy(driver,bPlace);
    }
    private WebElement getShippingPriceElement(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblShipping);
    }
    private WebElement getItemsPriceElement(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblItems);
    }
    private WebElement getGiftPackingPriceElement(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblGiftPacking);
    }
    private WebElement getTaxPriceElement(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblTax);
    }
    public WebElement getTotalPrice(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblTotal);
    }

    //Interations
    public void placeOrder(){
        getPlaceButton().click();
    }

    public String getTaxPrice(){
        ElementHelpers.waitForTextSetForElement(driver,getTaxPriceElement());
        return getTaxPriceElement().getText();
    }
    public String getItemPrice(){
        ElementHelpers.waitForTextSetForElement(driver,getItemsPriceElement());
        return getItemsPriceElement().getText();
    }
    public String getShippingPrice(){
        ElementHelpers.waitForTextSetForElement(driver,getShippingPriceElement());
         return getShippingPriceElement().getText();
    }
    public String getGiftPackingPrice(){
        ElementHelpers.waitForTextSetForElement(driver,getGiftPackingPriceElement());
        return getGiftPackingPriceElement().getText();
    }
}
