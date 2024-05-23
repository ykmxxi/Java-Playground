package org.example.chap6;

import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateTimeTest {

    @Test
    @DisplayName("날짜와 시간 조회")
    void 날짜_시간_조회() {
        LocalDateTime dt = LocalDateTime.of(2030, 1, 1, 13, 30, 59);

        // TemporalAccessor.get(TemporalField field)
        assertThat(dt.get(YEAR)).isEqualTo(2030);
        assertThat(dt.get(MONTH_OF_YEAR)).isEqualTo(1);

        // 자주 사용하는 기능은 편의 메서드를 제공
        assertThat(dt.getYear()).isEqualTo(2030);
        assertThat(dt.getMonthValue()).isEqualTo(1);
        assertThat(dt.getDayOfMonth()).isEqualTo(1);
        assertThat(dt.getHour()).isEqualTo(13);
        assertThat(dt.getMinute()).isEqualTo(30);
        assertThat(dt.getSecond()).isEqualTo(59);
    }

    @Test
    @DisplayName("날짜와 시간 조작")
    void 날짜_시간_조작() {
        LocalDateTime dt = LocalDateTime.of(2030, 1, 1, 13, 30, 59);

        // Temporal plus(long amountToAdd, TemporalUnit unit)
        LocalDateTime result1 = dt.plus(1, ChronoUnit.SECONDS);
        assertThat(result1.getSecond()).isEqualTo(0);
        assertThat(result1.getMinute()).isEqualTo(31);

        // 편의 메서드도 제공
        LocalDateTime result2 = dt.plus(10, ChronoUnit.YEARS);
        assertThat(result2.getYear()).isEqualTo(2040);

        // Period & Duration, 기간(시간의 간격)을 더할 수 있음
        Period period = Period.ofYears(10);
        LocalDateTime result3 = dt.plus(period);
        assertThat(result3.getYear()).isEqualTo(2040);
    }

    @Test
    @DisplayName("TemporalAccessor, Temporal 인터페이스는 현재 타입에서 특정 시간 단위나 필드를 사용할 수 있는지 확인할 수 있는 메서드를 제공")
    void isSupported() {
        LocalDate now = LocalDate.now();

        assertThat(now.isSupported(ChronoUnit.SECONDS)).isFalse(); // 초 미지원
        assertThat(now.isSupported(ChronoUnit.YEARS)).isTrue(); // 연 지원

        assertThat(now.isSupported(ChronoField.SECOND_OF_MINUTE)).isFalse();
        assertThat(now.isSupported(ChronoField.YEAR)).isTrue();
    }

}
