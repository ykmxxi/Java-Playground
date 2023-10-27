package 스트림;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ReducingTest {

    @Test
    void reduceTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when
        Integer result1 = numbers.stream()
                                 .reduce(1, (n1, n2) -> n1 * n2);
        Integer result2 = numbers.stream()
                                 .reduce(0, Integer::sum);
        Integer result3 = numbers.stream()
                                 .reduce(Integer::max)
                                 .orElse(0);

        // then
        assertThat(result1).isEqualTo(120);
        assertThat(result2).isEqualTo(15);
        assertThat(result3).isEqualTo(5);
    }

}
