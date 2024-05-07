package org.example.chap5.ex1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @Test
    @DisplayName("등급에 문자열 사용")
    void 문자열_입력_할인() {
        int price = 10_000;

        assertThat(discountService.stringDiscount(StringGrade.BASIC, price)).isEqualTo(1_000);
        assertThat(discountService.stringDiscount(StringGrade.GOLD, price)).isEqualTo(2_000);
        assertThat(discountService.stringDiscount(StringGrade.DIAMOND, price)).isEqualTo(3_000);
        // assertThat(discountService.stringDiscount(StringGrade.VIP, price)).isEqualTo(0); // 컴파일 오류 발생

        // 문제점: 문자열을 넘겨도 문제가 없음
        assertThat(discountService.stringDiscount("gold", price)).isEqualTo(0);
        assertThat(discountService.stringDiscount("DIAMOD", price)).isEqualTo(0);
    }

    @Test
    @DisplayName("등급에 문자열 상수 사용")
    void 문자열_상수_입력_할인() {
        int price = 10_000;

        assertThat(discountService.constantDiscount("BASIC", price)).isEqualTo(1_000);
        assertThat(discountService.constantDiscount("GOLD", price)).isEqualTo(2_000);
        assertThat(discountService.constantDiscount("DIAMOND", price)).isEqualTo(3_000);
        assertThat(discountService.constantDiscount("VIP", price)).isEqualTo(0);

        // 문제점
        assertThat(discountService.constantDiscount("gold", price)).isEqualTo(0);
        assertThat(discountService.constantDiscount("DIAMOD", price)).isEqualTo(0);
    }

}
