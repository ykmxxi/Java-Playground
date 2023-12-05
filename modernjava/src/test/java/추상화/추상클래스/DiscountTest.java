package 추상화.추상클래스;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DiscountTest {

    @Test
    void 크리스마스_할인() {
        // given
        Discount discount1 = new ChristmasDiscount(10000, 25);
        Discount discount2 = new ChristmasDiscount(9999, 25);
        Discount discount3 = new ChristmasDiscount(10000, 26);

        // when & then
        assertThat(discount1.canApply()).isTrue();
        assertThat(discount1.calculateDiscountAmount()).isEqualTo(3400);
        assertThat(discount2.canApply()).isFalse();
        assertThat(discount2.calculateDiscountAmount()).isEqualTo(0);
        assertThat(discount3.canApply()).isFalse();
        assertThat(discount3.calculateDiscountAmount()).isEqualTo(0);
    }

}
