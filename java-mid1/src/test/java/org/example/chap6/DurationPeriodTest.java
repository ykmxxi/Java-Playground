package org.example.chap6;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DurationPeriodTest {

    @Test
    @DisplayName("Period: 두 날짜 사이의 간격을 년, 월, 일 단위로")
    void period() {
        Period period = Period.ofDays(10); // 생성
        System.out.println("period = " + period);

        // 계산에 사용
        LocalDate currentDate = LocalDate.of(2030, 1, 1);
        LocalDate plusDate = currentDate.plus(period);
        System.out.println("currentDate = " + currentDate);
        System.out.println("plusDate = " + plusDate);

        // 기간 차이 계산
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 4, 2);
        Period between = Period.between(startDate, endDate);
        System.out.println("between = " + between.getMonths() + "개월 " + between.getDays() + "일");
    }

    @Test
    @DisplayName("Duration: 두 날짜 사이의 간격을 시, 분, 초(나노초) 단위로")
    void duration() {
        Duration duration = Duration.ofMinutes(30);
        System.out.println("duration = " + duration);

        LocalTime lt = LocalTime.of(1, 0);
        System.out.println("lt = " + lt);

        LocalTime plusTime = lt.plus(duration);
        System.out.println("plusTime = " + plusTime);

        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(10, 0);
        Duration between = Duration.between(start, end);
        System.out.println("between = " + between.getSeconds() + "초");
        System.out.println("between = " + between.toHours() + "시간 " + between.toMinutesPart() + "분");
    }

}
