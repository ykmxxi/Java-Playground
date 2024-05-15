package org.example.chap6;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDateTimeTest {

    private static final Logger log = LoggerFactory.getLogger(LocalDateTimeTest.class);

    @Test
    @DisplayName("LocalDate: 날짜 정보를 표현")
    void localDate() {
        LocalDate now = LocalDate.now(); // 현재 시간
        log.info("오늘 날짜: {}", now);

        LocalDate date = LocalDate.of(2024, 5, 15); // 지정 날짜
        assertThat(date.getDayOfMonth()).isEqualTo(15);
        assertThat(date.getMonthValue()).isEqualTo(5);
        assertThat(date.getYear()).isEqualTo(2024);

        // 계산, 주의할 점은 날짜와 시간 클래스는 불변 객체로 반환값을 받아야 한다
        LocalDate plusDays = date.plusDays(10);
        assertThat(plusDays.getDayOfMonth()).isEqualTo(25);
        assertThat(plusDays.getMonthValue()).isEqualTo(5);
        assertThat(plusDays.getYear()).isEqualTo(2024);
    }

    @Test
    @DisplayName("LocalTime: 시간 정보를 표현")
    void localTime() {
        LocalTime now = LocalTime.now();
        log.info("현재 시간: {}", now);

        LocalTime time = LocalTime.of(11, 22, 33);
        assertThat(time.getHour()).isEqualTo(11);
        assertThat(time.getMinute()).isEqualTo(22);
        assertThat(time.getSecond()).isEqualTo(33);

        LocalTime plusSeconds = time.plusSeconds(11);
        assertThat(plusSeconds.getHour()).isEqualTo(11);
        assertThat(plusSeconds.getMinute()).isEqualTo(22);
        assertThat(plusSeconds.getSecond()).isEqualTo(44);
    }

    @Test
    @DisplayName("LocalDateTime: 날짜시간 정보를 표현")
    void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        log.info("현재 날짜와 시간: {}", now);

        LocalDateTime dateTime = LocalDateTime.of(2024, 5, 15, 11, 22, 33);
        assertThat(dateTime.getYear()).isEqualTo(2024);
        assertThat(dateTime.getMonthValue()).isEqualTo(5);
        assertThat(dateTime.getDayOfMonth()).isEqualTo(15);
        assertThat(dateTime.getHour()).isEqualTo(11);
        assertThat(dateTime.getMinute()).isEqualTo(22);
        assertThat(dateTime.getSecond()).isEqualTo(33);

        // 날짜와 시간 분리
        LocalDate localDate = dateTime.toLocalDate();
        assertThat(localDate.getYear()).isEqualTo(2024);
        assertThat(localDate.getMonthValue()).isEqualTo(5);
        assertThat(localDate.getDayOfMonth()).isEqualTo(15);

        LocalTime localTime = dateTime.toLocalTime();
        assertThat(localTime.getHour()).isEqualTo(11);
        assertThat(localTime.getMinute()).isEqualTo(22);
        assertThat(localTime.getSecond()).isEqualTo(33);

        // 날짜와 시간 합체
        LocalDateTime dateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        log.info("날짜와 시간 합체: {}", dateTime1);

        // 계산(불변)
        LocalDateTime plusDays = dateTime.plusDays(10);
        assertThat(plusDays.getDayOfMonth()).isEqualTo(25);
        LocalDateTime plusMonths = dateTime.plusMonths(5);
        assertThat(plusMonths.getMonthValue()).isEqualTo(10);

        // 날짜 비교
        LocalDateTime before = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
        LocalDateTime after = LocalDateTime.of(2010, 1, 1, 0, 0, 0);

        assertThat(after.isAfter(before)).isTrue();
        assertThat(after.isBefore(before)).isFalse();
        assertThat(after.isEqual(before)).isFalse();

        // isEquals() vs equals
        LocalDate ld = LocalDate.of(2024, 1, 1);
        LocalTime lt1 = LocalTime.of(9, 0, 0);
        LocalTime lt2 = LocalTime.of(0, 0, 0);

        ZonedDateTime seoul = ZonedDateTime.of(ld, lt1, ZoneId.of("Asia/Seoul"));
        ZonedDateTime london = ZonedDateTime.of(ld, lt2, ZoneId.of("Europe/London"));

        log.info("seoul {}", seoul);
        log.info("london {}", london);
        assertThat(seoul.isEqual(london)).isTrue();
        assertThat(seoul.equals(london)).isFalse();
    }

}
