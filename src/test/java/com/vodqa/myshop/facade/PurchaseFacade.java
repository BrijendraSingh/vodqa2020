package com.vodqa.myshop.facade;

import com.vodqa.myshop.model.ShippingInfo;
import com.vodqa.myshop.pages.HomePage;
import com.vodqa.myshop.pages.ProductPage;
import com.vodqa.myshop.pages.ReviewOrderPage;
import com.vodqa.myshop.pages.factory.PageFactory;
import com.vodqa.myshop.tests.strategy.OtherValidationStrategy;
import com.vodqa.myshop.tests.strategy.AmountValidationStrategy;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PurchaseFacade {
    WebDriver driver;
    HomePage homePage;
    List<AmountValidationStrategy> validationStrategies=new ArrayList<>();

    public PurchaseFacade(WebDriver driver, AmountValidationStrategy amountValidationStrategy) {
        this.driver = driver;
        homePage = PageFactory.getPage(driver,HomePage.class);
        this.validationStrategies.add(new OtherValidationStrategy());
        this.validationStrategies.add(amountValidationStrategy);
    }

    public void purchaseItem(int item, String size, String color, String price, ShippingInfo shippingInfo){
                ProductPage productPage = homePage
                .get()
                .validateCategories(Arrays.asList("All","Food","Fruits","Electronics","Clothes Men","Clothes Women","Drinks","Groceries"))
                .clickNthProduct(item)
                .setSize(size)
                .setColor(color);



        assertThat(productPage
                .getPrice(price),is(price));

        ReviewOrderPage reviewOrderPage=
                productPage.buy()
                .setShippingAndContinue(shippingInfo);

        for (AmountValidationStrategy strategy:validationStrategies) {
            strategy.validate(reviewOrderPage, price, shippingInfo.getCountry());
        }
        reviewOrderPage.placeOrder();
    }
}
