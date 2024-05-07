package org.example.chap5.enumeration;

import static org.example.chap5.enumeration.Grade.BASIC;
import static org.example.chap5.enumeration.Grade.DIAMOND;
import static org.example.chap5.enumeration.Grade.GOLD;

public class EnumDiscountService {

    public int discount(final Grade grade, final int price) {
        int discountPercent = 0;
        if (grade == BASIC) {
            discountPercent = 10;
        } else if (grade == GOLD) {
            discountPercent = 20;
        } else if (grade == DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인 X");
        }
        return price * discountPercent / 100;
    }

}
