package org.example.chap6;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InstantTest {

    @Test
    @DisplayName("Instant: epoch time(UTC 1970-01-01T00:00:00 기준")
    void instant() {
        Instant instant = Instant.from(ZonedDateTime.of(1970, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")));
        assertThat(instant.getEpochSecond()).isEqualTo(0L);

        Instant start = Instant.ofEpochSecond(0L);
        assertThat(start.toString()).contains("1970-01-01", "00:00:00");
        System.out.println("start = " + start);

        ZonedDateTime zdt = ZonedDateTime.now();
        Instant now = Instant.from(zdt);
        System.out.println("now = " + now + ", seconds = " + now.getEpochSecond());
    }

}
