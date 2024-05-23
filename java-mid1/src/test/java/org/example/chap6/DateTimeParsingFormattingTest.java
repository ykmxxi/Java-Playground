package org.example.chap6;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTimeParsingFormattingTest {

    private DateTimeFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    @Test
    void parse() {
        String stringDateTime = "2030-01-01 13:30:00";

        LocalDateTime parsedDateTime = LocalDateTime.parse(stringDateTime, formatter);

        assertThat(parsedDateTime.getYear()).isEqualTo(2030);
        assertThat(parsedDateTime.getMonthValue()).isEqualTo(1);
        assertThat(parsedDateTime.getHour()).isEqualTo(13);
        assertThat(parsedDateTime.getMinute()).isEqualTo(30);
        assertThat(parsedDateTime.getSecond()).isEqualTo(0);
        System.out.println("parsedDateTime = " + parsedDateTime);
    }

    @Test
    void format() {
        LocalDateTime ldt = LocalDateTime.of(2024, 12, 31, 13, 30, 59);

        String formattedDateTime = ldt.format(formatter);

        assertThat(formattedDateTime).isEqualTo("2024-12-31 13:30:59");
        System.out.println("formattedDateTime = " + formattedDateTime);
    }

}
