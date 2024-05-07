package org.example.chap5.enumeration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.chap5.enumeration.Grade.BASIC;
import static org.example.chap5.enumeration.Grade.DIAMOND;
import static org.example.chap5.enumeration.Grade.GOLD;

import org.junit.jupiter.api.Test;

class EnumDiscountServiceTest {

    private final EnumDiscountService service = new EnumDiscountService();

    @Test
    void 열거형_할인() {
        int price = 10_000;

        // Grade grade = new Grade(); // 컴파일 오류, 열거형은 외부 생성 불가
        assertThat(BASIC).isInstanceOf(Grade.class);
        assertThat(GOLD).isInstanceOf(Grade.class);
        assertThat(DIAMOND).isInstanceOf(Grade.class);

        assertThat(service.discount(BASIC, price)).isEqualTo(1_000);
        assertThat(service.discount(GOLD, price)).isEqualTo(2_000);
        assertThat(service.discount(DIAMOND, price)).isEqualTo(3_000);

        // 열거형은 toString() 재정의 되어 있음
        assertThat(BASIC.toString()).isEqualTo("BASIC");
        assertThat(GOLD.toString()).isEqualTo("GOLD");
        assertThat(DIAMOND.toString()).isEqualTo("DIAMOND");
    }

}
