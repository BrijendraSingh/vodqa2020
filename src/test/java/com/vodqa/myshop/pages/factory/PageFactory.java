package com.vodqa.myshop.pages.factory;

import com.vodqa.myshop.pages.*;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class PageFactory {
    private static HashMap<Class<? extends BasePage<?>>,Factory> factoryRepository ;
    static {
        factoryRepository = new HashMap<>();
        PageFactory.register(HomePage.class,HomePage::new);
        PageFactory.register(ProductPage.class,ProductPage::new);
        PageFactory.register(ReviewOrderPage.class,ReviewOrderPage::new);
        PageFactory.register(ShippingInfoPage.class,ShippingInfoPage::new);
    }
    @FunctionalInterface
    public interface Factory<T extends BasePage<T>>{
        T get(WebDriver driver);
    }


    public static  <T extends BasePage<T>> void register(Class<T> tClass,Factory<T> factory){
        factoryRepository.put(tClass,factory);
    }
    public static <T extends BasePage> T getPage(WebDriver driver, Class<T> tClass){
        T page=null;
        try {
            page = (T) factoryRepository.get(tClass).get(driver);
        }catch (NullPointerException ex){
            throw (new RuntimeException("page "+tClass+" not registered"));
        }
        return page;
    }
}
