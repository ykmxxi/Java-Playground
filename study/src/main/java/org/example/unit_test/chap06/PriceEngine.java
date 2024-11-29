package org.example.unit_test.chap06;

import java.util.List;

public class PriceEngine {

    private static final double DISCOUNT_RATE = 0.01d;
    private static final double MIN_DISCOUNT = 0.02d;

    public double calculateDiscount(final List<Product> products) {
        double discount = DISCOUNT_RATE * products.size();
        return Math.min(discount, MIN_DISCOUNT);
    }

}
