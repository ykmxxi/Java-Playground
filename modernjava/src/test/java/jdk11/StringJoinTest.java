package jdk11;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class StringJoinTest {

    @Test
    void oneElement() {
        // given
        List<String> names = List.of("kim");

        // when
        String result = String.join(", ", names);

        // then
        assertThat(result).isEqualTo("kim");
        System.out.println("result = " + result);
    }

    @Test
    void moreTwoElements() {
        // given
        List<String> names1 = List.of("kim", "park");
        List<String> names2 = List.of("kim", "park", "lee");

        // when
        String result1 = String.join(" : ", "우승자", String.join(", ", names1));
        String result2 = String.join(" : ", "우승자", String.join(", ", names2));

        // then
        assertThat(result1).isEqualTo("우승자 : kim, park");
        System.out.println("result1 = " + result1);
        assertThat(result2).isEqualTo("우승자 : kim, park, lee");
        System.out.println("result2 = " + result2);
    }

}
