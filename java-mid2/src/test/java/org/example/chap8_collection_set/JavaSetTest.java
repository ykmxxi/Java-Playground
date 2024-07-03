package org.example.chap8_collection_set;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaSetTest {

    private Set<Integer> set;

    @BeforeEach
    void setUp() {
        set = new HashSet<>();
    }

    @Test
    void 데이터_추가() {
        addData();

        assertThat(set.size()).isEqualTo(6);
        assertThat(set).contains(1, 2, 5, 8, 14, 99);

        Set<Integer> addAllSet = new HashSet<>();
        addAllSet.addAll(set);

        assertThat(addAllSet.size()).isEqualTo(6);
        assertThat(addAllSet).contains(1, 2, 5, 8, 14, 99);
    }

    @Test
    void 데이터_삭제() {
        addData();

        set.remove(1);
        assertThat(set.containsAll(List.of(2, 5, 8, 14, 99))).isTrue();
        assertThat(set.contains(1)).isFalse();

        set.removeAll(List.of(2, 8, 14));
        assertThat(set.containsAll(List.of(5, 99))).isTrue();
        assertThat(set).doesNotContain(2, 8, 14);

        set.clear();

        addData();
        set.retainAll(List.of(1, 5, 8));
        assertThat(set.containsAll(List.of(1, 5, 8))).isTrue();
        assertThat(set).doesNotContain(2, 14, 99);
    }

    @Test
    void 이외_기능들() {
        addData();

        assertThat(set.isEmpty()).isFalse();

        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        assertThat(arr).contains(1, 2, 5, 8, 14, 99);
    }

    private void addData() {
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(8);
        set.add(14);
        set.add(99);
        set.add(1);
    }
    
}
