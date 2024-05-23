package org.example.chap6;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProblemTest {

    @Test
    @DisplayName("2024-01-01T00:00에 1년 2개월 3일 4시간 후의 시각을 찾기")
    void problem1() {
        LocalDateTime ldt = LocalDateTime.of(2024, 1, 1, 0, 0, 0);

        LocalDateTime result = ldt.plusYears(1)
                .plusMonths(2)
                .plusDays(3)
                .plusHours(4);

        assertThat(result.getYear()).isEqualTo(2025);
        assertThat(result.getMonthValue()).isEqualTo(3);
        assertThat(result.getDayOfMonth()).isEqualTo(4);
        assertThat(result.getHour()).isEqualTo(4);
        System.out.println("result = " + result);
    }

    @Test
    @DisplayName("2024-01-01 부터 2주 간격으로 5번 반복해 날짜를 출력")
    void problem2() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        for (int i = 0; i < 5; i++) {
            LocalDate nextDate = startDate.plusWeeks(2 * i);
            System.out.println("날짜 " + (i + 1) + ": " + nextDate);
        }
    }

    @Test
    @DisplayName("디데이 구하기")
    void problem3() {
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 11, 21);

        // 남은 기간: 0년 10개월 20일
        Period period = Period.between(start, end);
        assertThat(period.getYears()).isEqualTo(0);
        assertThat(period.getMonths()).isEqualTo(10);
        assertThat(period.getDays()).isEqualTo(20);

        // 디데이: 325
        long dDay = ChronoUnit.DAYS.between(start, end);
        assertThat(dDay).isEqualTo(325L);
    }

    @Test
    @DisplayName("입력 받은 월의 첫날 요일과 마지막날 요일 구하기")
    void problem4() {
        int year = 2024;
        int month = 1;

        LocalDate localDate = LocalDate.of(year, month, 1);
        DayOfWeek firstDayOfWeek = localDate.getDayOfWeek();
        System.out.println("firstDayOfWeek = " + firstDayOfWeek);

        DayOfWeek lastDayOfWeek = localDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
        System.out.println("lastDayOfWeek = " + lastDayOfWeek);
    }

    @Test
    void problem5() {
        ZonedDateTime seoul = ZonedDateTime.of(2024, 1, 1, 9, 0, 0, 0, ZoneId.of("Asia/Seoul"));
        ZonedDateTime london = seoul.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime newYork = seoul.withZoneSameInstant(ZoneId.of("America/New_York"));

        assertThat(london.getHour()).isEqualTo(0);
        assertThat(newYork.getHour()).isEqualTo(19);

        System.out.println("seoul = " + seoul);
        System.out.println("london = " + london);
        System.out.println("newYork = " + newYork);
    }

    @Test
    @DisplayName("2020 ~ 2029년 달력 랜덤 출력")
    void problem6() {
        Random random = new Random();
        int year = random.nextInt(10) + 2020;
        int month = random.nextInt(12) + 1;
        LocalDate localDate = LocalDate.of(year, month, 1);

        System.out.println(year + "년 " + month + "월 달력");
        int offsetWeekDays = localDate.getDayOfWeek().getValue() % 7;// mon: 1, sun: 7
        System.out.println("Su Mo Tu We Th Fr Sa ");
        for (int i = 0; i < offsetWeekDays; i++) {
            System.out.print("   ");
        }

        LocalDate iterator = localDate;
        while (iterator.isBefore(localDate.plusMonths(1))) {
            {
                System.out.printf("%2d ", iterator.getDayOfMonth());
                if (iterator.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    System.out.println();
                }
                iterator = iterator.plusDays(1);
            }
        }
    }

}
