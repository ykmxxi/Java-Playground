package jdk17;

import java.util.List;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamToListTest {

    @Test
    void streamToListTest() {
        // given
        List<Integer> numbers = IntStream.rangeClosed(1, 10)
                .boxed()
                .toList();

        // when & then
        Assertions.assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> {
                    numbers.add(11);
                });
    }

}
