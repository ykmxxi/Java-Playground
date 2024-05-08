package org.example.chap5.enumeration;

public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30);

    private final int discountPercent;

    Grade(final int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int discount(final int price) {
        return price * discountPercent / 100;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

}
