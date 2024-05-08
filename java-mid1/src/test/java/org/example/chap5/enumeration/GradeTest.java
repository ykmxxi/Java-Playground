package org.example.chap5.enumeration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.example.chap5.enumeration.Grade.BASIC;
import static org.example.chap5.enumeration.Grade.DIAMOND;
import static org.example.chap5.enumeration.Grade.GOLD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GradeTest {

    @Test
    @DisplayName("values(): 모든 enum 상수를 배열로 반환")
    void values() {
        Grade[] values = Grade.values();

        assertThat(values).containsExactly(BASIC, GOLD, DIAMOND);
        assertThat(values).extracting(Enum::name) // name(): enum 상수의 이름을 문자열로 반환
                .containsExactly("BASIC", "GOLD", "DIAMOND");
    }

    @Test
    @DisplayName("valueOf(String name): 주어진 이름과 일치하는 enum 상수를 반환")
    void valueOf() {
        assertThat(Grade.valueOf("BASIC")).isEqualTo(BASIC);
        assertThat(Grade.valueOf("GOLD")).isEqualTo(GOLD);
        assertThat(Grade.valueOf("DIAMOND")).isEqualTo(DIAMOND);

        // 잘못된 이름을 넣으면 IllegalArgumentException 발생
        assertThatThrownBy(() -> Grade.valueOf("gold"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("toString(): enum 상수의 이름을 문자열로 반환")
    void enum_toString() {
        assertThat(BASIC.toString()).isEqualTo("BASIC");
        assertThat(GOLD.toString()).isEqualTo("GOLD");
        assertThat(DIAMOND.toString()).isEqualTo("DIAMOND");
    }

    @Test
    @DisplayName("대상 할인 금액 계산 책임을 Grade 클래스에 부여한다")
    void discount() {
        int price = 10_000;

        assertThat(BASIC.discount(price)).isEqualTo(1_000);
        assertThat(GOLD.discount(price)).isEqualTo(2_000);
        assertThat(DIAMOND.discount(price)).isEqualTo(3_000);
    }

}
