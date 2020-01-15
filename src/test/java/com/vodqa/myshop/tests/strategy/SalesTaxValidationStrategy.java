package com.vodqa.myshop.tests.strategy;


import com.vodqa.myshop.pages.ReviewOrderPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SalesTaxValidationStrategy implements AmountValidationStrategy {
    @Override
    public void validate(ReviewOrderPage reviewOrderPage, String price, String country) {
        assertThat(reviewOrderPage.getTaxPrice(),is(String.format("%.2f", CalculationService.calculateSalesTax(Double.parseDouble(price),country))));
    }
}
