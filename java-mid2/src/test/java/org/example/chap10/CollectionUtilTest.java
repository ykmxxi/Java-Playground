package org.example.chap10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionUtilTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test
    @DisplayName("정렬과 관련된 컬렉션 유틸")
    void collectionsSort() {
        assertThat(Collections.max(list)).isEqualTo(5);
        assertThat(Collections.min(list)).isEqualTo(1);

        Collections.shuffle(list);
        System.out.println("shuffle list = " + list);

        Collections.sort(list);
        assertThat(list).containsExactly(1, 2, 3, 4, 5);

        Collections.reverse(list);
        assertThat(list).containsExactly(5, 4, 3, 2, 1);
    }

    @Test
    @DisplayName("불변 컬렉션: 추가, 삭제, 변경 시 UnsupportedOperationException 예외 발생")
    void immutableCollection() {
        List<Integer> immutableList = List.of(1, 2, 3, 4, 5);

        System.out.println("immutableList.class = " + immutableList.getClass());
        assertThatThrownBy(() -> immutableList.add(6))
                .isInstanceOf(UnsupportedOperationException.class);

        Set<Integer> immutableSet = Set.of(1, 2, 3);
        Map<Integer, String> immutableMap = Map.of(1, "one", 2, "two");
    }

    @Test
    @DisplayName("불변, 가변 컬렉션 간의 전환")
    void immutableMutableExchange() {
        // 가변 -> 불변
        List<Integer> immutableList = Collections.unmodifiableList(list);

        assertThatThrownBy(() -> immutableList.add(6))
                .isInstanceOf(UnsupportedOperationException.class);

        // 불변 -> 가변
        List<Integer> mutableList = new ArrayList<>(immutableList);
        mutableList.add(6);

        assertThat(mutableList).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("빈 리스트 생성")
    void emptyList() {
        List<Integer> emptyList1 = new ArrayList<>();
        List<Integer> emptyList2 = new LinkedList<>();
        List<Integer> emptyList3 = Collections.emptyList();
        List<Integer> emptyList4 = List.of();

        assertThat(emptyList1).isEmpty();
        assertThat(emptyList2).isEmpty();
        assertThat(emptyList3).isEmpty();
        assertThat(emptyList4).isEmpty();
    }

    @Test
    @DisplayName("Arrays.asList(): 길이가 고정된 불변, 가변도 아닌 애매한 리스트로 수정만 가능")
    void arraysAsList() {
        // Java 1.2부터 존재한 오래된 기능
        // 길이가 고정된 리스트
        Integer[] arr = {1, 2, 3};
        List<Integer> list = Arrays.asList(arr);

        // 추가, 삭제가 불가능
        assertThatThrownBy(() -> list.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> list.remove(1))
                .isInstanceOf(UnsupportedOperationException.class);

        // 수정은 가능, 배열의 참조값을 가져다 써 배열도 함께 변경됨
        list.set(0, 10);
        assertThat(list).containsExactly(10, 2, 3);
        assertThat(arr[0]).isEqualTo(10);
    }

    @Test
    @DisplayName("동기화 리스트: 멀티스레드 환경에서 사용")
    void synchronizedList() {
        assertThat(list).isInstanceOf(ArrayList.class);

        List<Integer> synchronizedList = Collections.synchronizedList(list);
        System.out.println(synchronizedList.getClass());
    }

}
