package jdk11;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionFactoryMethodInJdk11Test {

    /**
     * List.of(): 불변 리스트(Immutable List) 생성
     * - 값 추가, 삭제, 변경 불가능
     * - 하지만 재할당 가능
     */
    @Test
    @DisplayName("List Factory Method")
    void listFactory_test() {
        // given
        List<Integer> list = List.of(1, 2, 3);
        List<Integer> before = List.of(1, 2, 3, 4);

        // when & then
        assertThatThrownBy(() -> list.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> list.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> list.set(0, 0))
                .isInstanceOf(UnsupportedOperationException.class);

        before = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(before).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("Collections가 제공하는 empty collection")
    void test() {
        // given
        List<Integer> emptyList = Collections.emptyList();

        // when & then
        assertThatThrownBy(() -> emptyList.add(1))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThat(emptyList.isEmpty()).isTrue();
    }

}
