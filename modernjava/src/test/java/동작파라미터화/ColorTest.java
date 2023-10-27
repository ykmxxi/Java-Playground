package 동작파라미터화;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ColorTest {

    @Test
    void equalsTest() {
        Color red1 = Color.RED;
        Color red2 = Color.RED;

        assertThat(red1).isEqualTo(red2);
        assertThat(red1.equals(red2)).isTrue();
    }

}
