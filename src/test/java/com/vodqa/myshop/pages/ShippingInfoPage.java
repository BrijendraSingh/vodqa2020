package com.vodqa.myshop.pages;

import com.vodqa.myshop.helpers.ElementHelpers;
import com.vodqa.myshop.model.ShippingInfo;
import com.vodqa.myshop.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingInfoPage extends BasePage<ShippingInfoPage>{
    public ShippingInfoPage(WebDriver driver)
    {
        super(driver);
    }

    //Locators
    By ddCountry=By.id("country");
    By txtFirstName=By.cssSelector("input[name='firstName']");
    By txtLastName=By.cssSelector("input[name='lastName']");
    By bContinue=By.id("continueButton");

    //Elements
    private Select getCountry(){
        return ElementHelpers.getDropDownSaflyBy(driver,ddCountry);
    }
    private WebElement getFirstName(){
        return ElementHelpers.getWebElementSaflyBy(driver,txtFirstName);
    }
    private WebElement getLastName(){
        return ElementHelpers.getWebElementSaflyBy(driver,txtLastName);
    }
    private WebElement getContinueButton(){
        return ElementHelpers.getWebElementSaflyBy(driver,bContinue);
    }


    //Interactions
    public ReviewOrderPage setShippingAndContinue(ShippingInfo shipping){
        ElementHelpers.selectSafly(getCountry(),shipping.getCountry());
        ElementHelpers.setTextSafly(getFirstName(),shipping.getFirstName());
        ElementHelpers.setTextSafly(getLastName(),shipping.getLastName());
        getContinueButton().click();
        return PageFactory.getPage(driver,ReviewOrderPage.class);
    }
}
