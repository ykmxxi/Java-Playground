package junit_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class JunitTest {

    @ParameterizedTest
    @MethodSource("testData")
    void methodSourceTest(String result, String expected) {
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Hello", "Hello"),
                Arguments.of("World", "World")
        );
    }

}
