package org.example.chap4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class WrapperClassTest {

    @Test
    void 래퍼_클래스_객체_생성() {
        assertDoesNotThrow(() -> {
            Integer integer = Integer.valueOf(10);
            Long longNum = Long.valueOf(10L);

            Float floatNum = Float.valueOf(3.14f);
            Double doubleNum = Double.valueOf(3.14);

            Character character = Character.valueOf('a');

            Boolean aTrue = Boolean.valueOf("true");
            Boolean aFalse = Boolean.valueOf(false);

            // 오토박싱
            Integer autoBoxing = 10;
        });
    }

    @Test
    void 언박싱() {
        Integer integer = Integer.valueOf(10);
        Double doubleNum = Double.valueOf(3.14);
        Character character = Character.valueOf('a');
        Boolean aTrue = Boolean.valueOf("true");
        Boolean aFalse = Boolean.valueOf(false);

        assertThat(integer.intValue()).isEqualTo(10);
        assertThat(doubleNum.doubleValue()).isEqualTo(3.14);
        assertThat(character.charValue()).isEqualTo('a');
        assertThat(aTrue.booleanValue()).isEqualTo(true);
        assertThat(aFalse.booleanValue()).isEqualTo(false);
    }

    @Test
    void 래퍼_클래스_비교_equals() {
        // -128 ~ 127은 미리 생성해둔 객체를 풀에서 가져와 할당하기 때문에 == 비교 통과
        Integer int1 = Integer.valueOf(127);
        Integer int2 = Integer.valueOf(127);
        assertThat(int1 == int2).isTrue();
        assertThat(int1.equals(int2)).isTrue();

        Integer int3 = Integer.valueOf(-128);
        Integer int4 = Integer.valueOf(-128);
        assertThat(int3 == int4).isTrue();
        assertThat(int3.equals(int4)).isTrue();

        Integer integer1 = Integer.valueOf(128);
        Integer integer2 = Integer.valueOf(128);
        assertThat(integer1 == integer2).isFalse();
        assertThat(integer1.equals(integer2)).isTrue();

        // 오토 박싱으로 비교
        assertThat(Integer.valueOf(10)).isEqualTo(10);
        assertThat(Boolean.valueOf("true")).isEqualTo(true);
    }

    @Test
    void 래퍼_클래스_toString() {
        // 기본값을 문자열로 반환
        assertThat(Integer.valueOf(10).toString()).isEqualTo("10");
        assertThat(Boolean.valueOf("true").toString()).isEqualTo("true");
    }

}
