package com.vodqa.myshop.tests.strategy;


import com.vodqa.myshop.pages.ReviewOrderPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OtherValidationStrategy implements AmountValidationStrategy {
    @Override
    public void validate(ReviewOrderPage reviewOrderPage, String price, String country) {
        assertThat(reviewOrderPage.getItemPrice(),is(String.format("%.2f", Double.parseDouble(price))));
        assertThat(reviewOrderPage.getGiftPackingPrice(),is(String.format("%.2f", CalculationService.calculateGift(Double.parseDouble(price)))));
        assertThat(reviewOrderPage.getShippingPrice(),is(String.format("%.2f", CalculationService.calculateShipping(Double.parseDouble(price)))));
    }
}
