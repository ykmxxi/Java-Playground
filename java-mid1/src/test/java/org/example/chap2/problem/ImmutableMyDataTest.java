package org.example.chap2.problem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ImmutableMyDataTest {

    private ImmutableMyData data = new ImmutableMyData(2024, 4, 27);

    @Test
    void withYear() {
        ImmutableMyData result = data.withYear(2025);

        assertThat(result.getYear()).isEqualTo(2025);
        assertThat(result.getMonth()).isEqualTo(4);
        assertThat(result.getDay()).isEqualTo(27);
    }

    @Test
    void withMonth() {
        ImmutableMyData result = data.withMonth(5);

        assertThat(result.getYear()).isEqualTo(2024);
        assertThat(result.getMonth()).isEqualTo(5);
        assertThat(result.getDay()).isEqualTo(27);
    }

    @Test
    void withDay() {
        ImmutableMyData result = data.withDay(30);

        assertThat(result.getYear()).isEqualTo(2024);
        assertThat(result.getMonth()).isEqualTo(4);
        assertThat(result.getDay()).isEqualTo(30);
    }

}
