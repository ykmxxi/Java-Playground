package org.example.chap6;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ZonedDateTimeTest {

    @Test
    @DisplayName("ZoneId: 타임존 정보")
    void zoneId() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println("availableZoneId = " + availableZoneId);

            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println("zoneId.getRules() = " + zoneId.getRules());
        }

        ZoneId systemZoneId = ZoneId.systemDefault();
        assertThat(systemZoneId.getId()).isEqualTo("Asia/Seoul");
    }

    @Test
    @DisplayName("ZonedDateTime: LocalDateTime에 ZoneId 합쳐진 정보")
    void zonedDateTime() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);
        assertThat(now.getZone().getId()).isEqualTo("Asia/Seoul");

        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Asia/Seoul"));
        System.out.println("zdt = " + zdt);

        // 타임존 변경
        ZonedDateTime utc = zdt.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("utc = " + utc);
        assertThat(utc.getHour()).isEqualTo(4);
    }

    @Test
    @DisplayName("OffsetDateTime: LocalDateTime에 UTC 시간차 정보인 Offset 정보만 포함")
    void offsetDateTime() {
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        OffsetDateTime odt = OffsetDateTime.of(ldt, ZoneOffset.of("+01:00"));
        System.out.println("odt = " + odt);
    }

}
