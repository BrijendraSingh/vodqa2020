package com.vodqa.myshop.pages;

import com.vodqa.myshop.helpers.ElementHelpers;
import com.vodqa.myshop.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends BasePage<HomePage> {

    public HomePage(WebDriver driver) {
        super(driver);
        url="http://localhost:8000/static/products";
    }
    @Override
    protected HomePage navigate(){
        super.navigate();
        return this;
    }

    //Locators
    private By ddCategory=By.id("filter-category");
    private By ddSubCategory=By.id("filter-subCategory");
    private By ddBrand=By.id("filter-brand");
    private By txtSearchText=By.id("filter-text");
    private By lstProducts=By.cssSelector(".product-card-wrap");

    //Elements
    private Select getCategory(){
        return ElementHelpers.getDropDownSaflyBy(driver,ddCategory);
    }
    private Select getSubCategory(){
        return ElementHelpers.getDropDownSaflyBy(driver,ddSubCategory);
    }
    private Select getBrand(){
        return ElementHelpers.getDropDownSaflyBy(driver,ddBrand);
    }
    private WebElement getSearchText(){
        return ElementHelpers.getWebElementSaflyBy(driver,txtSearchText);
    }
    private List<WebElement> getProducts(){
        return ElementHelpers.getWebElementsSaflyBy(driver,lstProducts);
    }

    public void clickFirstProduct(){
        getProducts().get(0).click();
    }
    public ProductPage clickNthProduct(int n){
        getProducts().get(n).click();
        return PageFactory.getPage(driver,ProductPage.class);
    }

    //Validations
    public HomePage validateCategories(List<String> categories){
        for (WebElement el: getCategory().getOptions()){
            assertThat(categories,hasItem(el.getText()));
        }
        return this;
    }
}
