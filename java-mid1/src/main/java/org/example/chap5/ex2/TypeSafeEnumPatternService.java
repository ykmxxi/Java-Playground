package org.example.chap5.ex2;

public class TypeSafeEnumPatternService {

    public int discount(final ClassGrade grade, final int price) {
        int discountPercent = 0;
        if (grade == ClassGrade.BASIC) {
            discountPercent = 10;
        } else if (grade == ClassGrade.GOLD) {
            discountPercent = 20;
        } else if (grade == ClassGrade.DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인 X");
        }
        return price * discountPercent / 100;
    }

}
