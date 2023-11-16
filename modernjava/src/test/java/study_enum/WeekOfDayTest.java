package study_enum;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

class WeekOfDayTest {

    @ParameterizedTest
    @EnumSource(names = {"SATURDAY", "SUNDAY"}, mode = Mode.INCLUDE)
    void 주말_테스트(WeekOfDay weekOfDay) {
        // when
        assertThat(weekOfDay.isWeekend()).isTrue();
    }

    @ParameterizedTest
    @EnumSource(names = {"SATURDAY", "SUNDAY"}, mode = Mode.EXCLUDE)
    void 평일_테스트(WeekOfDay weekOfDay) {
        // when
        assertThat(weekOfDay.isWeekend()).isFalse();
    }

}
