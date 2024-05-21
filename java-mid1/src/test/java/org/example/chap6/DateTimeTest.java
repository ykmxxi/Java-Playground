package org.example.chap6;

import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateTimeTest {

    @Test
    @DisplayName("날짜와 시간 조회")
    void 날짜_시간_조회() {
        LocalDateTime dt = LocalDateTime.of(2030, 1, 1, 13, 30, 59);

        assertThat(dt.get(YEAR)).isEqualTo(2030);
        assertThat(dt.get(MONTH_OF_YEAR)).isEqualTo(1);

        assertThat(dt.getYear()).isEqualTo(2030);
        assertThat(dt.getMonthValue()).isEqualTo(1);
        assertThat(dt.getDayOfMonth()).isEqualTo(1);
        assertThat(dt.getHour()).isEqualTo(13);
        assertThat(dt.getMinute()).isEqualTo(30);
        assertThat(dt.getSecond()).isEqualTo(59);

    }

}
