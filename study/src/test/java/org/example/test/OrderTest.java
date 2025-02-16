package org.example.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @DisplayName("제어할 수 없는 요소 LocalDateTime.now()가 존재해 테스트가 어려움: 일요일에 돌릴 때만 성공")
    @Test
    void discountBad() {
        double discountedPrice = order.discountBad();
        // 항상 동일한 경과를 보장하지 못함
        // 동일한 결과를 내는 테스트로 만들려면 LocalDateTime.now() 를 Mocking 해야만 수행가능한데, 이 역시 쉽지 않다.
        // 일요일에만 돌려야 성공
        // assertThat(discountedPrice).isEqualTo(900);

        // 일요일이 아닐 때에는 아래 메서드로
        // assertThat(discountedPrice).isEqualTo(1_000);
    }

    @DisplayName("제어할 수 없는 요소 LocalDateTime.now()를 외부로 분리")
    @Test
    void discount() {
        double sundayPrice = order.discount(DayOfWeek.SUNDAY);
        double mondayPrice = order.discount(DayOfWeek.MONDAY);

        assertThat(sundayPrice).isEqualTo(900);
        assertThat(mondayPrice).isEqualTo(1_000);
    }

}
