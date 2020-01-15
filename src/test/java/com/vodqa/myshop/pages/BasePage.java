package com.vodqa.myshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public  abstract class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {
    String url;
    WebDriver driver;
    protected BasePage navigate(){
        driver.navigate().to(url);
        return null;
    }
    protected BasePage(WebDriver driver) {
        this.driver=driver;
    }

    @Override
    protected void load() {
        navigate();
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(driver.getCurrentUrl().equals(url));
    }
}
