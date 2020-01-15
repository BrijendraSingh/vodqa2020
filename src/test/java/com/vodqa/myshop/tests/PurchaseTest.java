package com.vodqa.myshop.tests;

import com.vodqa.myshop.facade.PurchaseFacade;
import com.vodqa.myshop.helpers.DriverHelper;
import com.vodqa.myshop.model.ShippingInfo;
import com.vodqa.myshop.tests.strategy.SalesTaxValidationStrategy;
import com.vodqa.myshop.tests.strategy.VatTaxValidationStrategy;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PurchaseTest {

    @Test
    public void firstTest(){
        WebDriver driver= DriverHelper.getNewChromeDriver();
        PurchaseFacade purchaseFacade=new PurchaseFacade(driver,new SalesTaxValidationStrategy());
        ShippingInfo shippingInfo=new ShippingInfo();
        shippingInfo.setLastName("Naik");
        shippingInfo.setFirstName("Atmaram");
        shippingInfo.setCountry("China");
        purchaseFacade.purchaseItem(0,"M","Green","8757.84",shippingInfo);
        driver.quit();
    }
    @Test
    public void secondTest(){
        WebDriver driver= DriverHelper.getNewChromeDriver();
        PurchaseFacade purchaseFacade=new PurchaseFacade(driver,new VatTaxValidationStrategy());
        ShippingInfo shippingInfo=new ShippingInfo();
        shippingInfo.setLastName("Naik");
        shippingInfo.setFirstName("Atmaram");
        shippingInfo.setCountry("India");
        purchaseFacade.purchaseItem(0,"L","Blue","13576.256",shippingInfo);
        driver.quit();
    }

}
