package com.vodqa.myshop.tests.strategy;


import com.vodqa.myshop.pages.ReviewOrderPage;

public interface AmountValidationStrategy {
    public void validate(ReviewOrderPage reviewOrderPage, String price, String country);
}
