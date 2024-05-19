package org.example.chap6;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TemporalUnitTest {

    @Test
    @DisplayName("TemporalUnit(ChronoUnit): 시간의 단위를 나타내는 열거형")
    void temporal_chrono_unit() {
        ChronoUnit[] values = ChronoUnit.values();
        for (ChronoUnit value : values) {
            System.out.println("value = " + value);
        }

        System.out.println("HOURS = " + ChronoUnit.HOURS);
        System.out.println("HOURS.Duration.Seconds = " + ChronoUnit.HOURS.getDuration().getSeconds()); // 3600

        // 하루는 86400초
        System.out.println("DAYS.Duration.Seconds = " + ChronoUnit.DAYS.getDuration().getSeconds());

        LocalTime lt1 = LocalTime.of(1, 10, 0);
        LocalTime lt2 = LocalTime.of(1, 20, 0);
        assertThat(ChronoUnit.SECONDS.between(lt1, lt2)).isEqualTo(600L);
        assertThat(ChronoUnit.MINUTES.between(lt1, lt2)).isEqualTo(10L);
    }

    @Test
    @DisplayName("TemporalField(ChronoField): 날짜 및 시간을 나타내는데 사용되는 열거형")
    void temporal_chrono_field() {
        ChronoField[] values = ChronoField.values();
        for (ChronoField value : values) {
            System.out.println("value = " + value + ", range = " + value.range());
        }

        System.out.println("MONTH_OF_YEAR.range() = " + ChronoField.MONTH_OF_YEAR.range());
        System.out.println("DAY_OF_MONTH.range() = " + ChronoField.DAY_OF_MONTH.range());
    }

}
