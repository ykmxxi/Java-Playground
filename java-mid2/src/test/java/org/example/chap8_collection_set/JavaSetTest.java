package org.example.chap8_collection_set;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaSetTest {

    private Set<Integer> hashSet;
    private Set<Integer> linkedHashSet;

    @BeforeEach
    void setUp() {
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
    }

    @Test
    void 데이터_추가() {
        addData(hashSet);

        assertThat(hashSet.size()).isEqualTo(6);
        assertThat(hashSet).contains(1, 2, 5, 8, 14, 99);

        Set<Integer> addAllSet = new HashSet<>();
        addAllSet.addAll(hashSet);

        assertThat(addAllSet.size()).isEqualTo(6);
        assertThat(addAllSet).contains(1, 2, 5, 8, 14, 99);

        // LinkedHashSet은 순서도 유지
        addData(linkedHashSet);
        assertThat(linkedHashSet).containsExactly(1, 2, 5, 8, 14, 99);
    }

    @Test
    void 데이터_삭제() {
        addData(hashSet);

        hashSet.remove(1);
        assertThat(hashSet.containsAll(List.of(2, 5, 8, 14, 99))).isTrue();
        assertThat(hashSet.contains(1)).isFalse();

        hashSet.removeAll(List.of(2, 8, 14));
        assertThat(hashSet.containsAll(List.of(5, 99))).isTrue();
        assertThat(hashSet).doesNotContain(2, 8, 14);

        hashSet.clear();

        addData(hashSet);
        hashSet.retainAll(List.of(1, 5, 8));
        assertThat(hashSet.containsAll(List.of(1, 5, 8))).isTrue();
        assertThat(hashSet).doesNotContain(2, 14, 99);

        addData(linkedHashSet);
        linkedHashSet.remove(1);
        linkedHashSet.remove(8);
        assertThat(linkedHashSet).containsExactly(2, 5, 14, 99);
    }

    @Test
    void 이외_기능들() {
        addData(hashSet);

        assertThat(hashSet.isEmpty()).isFalse();

        Integer[] arr = new Integer[hashSet.size()];
        hashSet.toArray(arr);
        assertThat(arr).contains(1, 2, 5, 8, 14, 99);
    }

    private void addData(final Set<Integer> set) {
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(8);
        set.add(14);
        set.add(99);
    }

}
