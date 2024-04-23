package org.example.chap1.problem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    void test() {
        Rectangle rect1 = new Rectangle(100, 20);
        Rectangle rect2 = new Rectangle(100, 20);

        assertThat(rect1.toString()).contains("width=100", "height=20");

        assertThat(rect1 == rect2).isFalse();
        assertThat(rect1.equals(rect2)).isTrue();
    }

}
