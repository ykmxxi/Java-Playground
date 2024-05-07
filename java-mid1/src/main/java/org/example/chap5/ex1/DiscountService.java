package org.example.chap5.ex1;

/**
 * 고객을 3등급으로 나누고, 상품 구매시 등급별 할인 적용, 할인시 소수점 이하는 버림
 * - BASIC -> 10%, GOLD -> 20%, DIAMOND -> 30%
 * - 등급에 문자열을 사용 -> 문제점 발생
 * - 등급에 문자열 상수를 사용 -> 여전히 문제점 발생
 */
public class DiscountService {


    /**
     * 문자열 사용 시 문제점
     * - 타입 안전성 부족: 오타 발생과 유효하지 않은 값이 입력될 수 있다
     * - 데이터 일관성: 문자열은 다양한 형식(GOLD, Gold, gold 등)으로 입력할 수 있어 일관성이 떨어진다
     * - 값의 제한 부족: String로 상태나 카테고리를 표현하면 잘못된 문자열을 실수로 입력할 가능성이 있다
     * 예를 들어 Monday, Tuesday 등을 나타내는데 String을 사용하면 오타나 잘못된 값이 입력될 위험이 있다
     * - 컴파일 시 오류 감지 불가: 이러한 잘못된 값이 컴파일 시점에 감지되지 않고 런타임에서만 발견되어 디버깅이 어렵다
     */
    public int stringDiscount(final String grade, final int price) {
        int discountPercent = 0;
        if ("BASIC".equals(grade)) {
            discountPercent = 10;
        } else if ("GOLD".equals(grade)) {
            discountPercent = 20;
        } else if ("DIAMOND".equals(grade)) {
            discountPercent = 30;
        } else {
            System.out.println(grade + ": 할인 X");
        }
        return price * discountPercent / 100;
    }

    /**
     * 애초에 메서드 인자로 문자열을 사용한 것이 문제다
     * 인자로 BASIC, GOLD, DIAMOND만 들어올 수 있게 막아야 한다 -> 열거형 도입
     */
    public int constantDiscount(final String grade, final int price) {
        int discountPercent = 0;
        if (StringGrade.BASIC.equals(grade)) {
            discountPercent = 10;
        } else if (StringGrade.GOLD.equals(grade)) {
            discountPercent = 20;
        } else if (StringGrade.DIAMOND.equals(grade)) {
            discountPercent = 30;
        } else {
            System.out.println(grade + ": 할인 X");
        }
        return price * discountPercent / 100;
    }

}
