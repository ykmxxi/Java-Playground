package org.example.chap8_collection_set;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaSetTest {

    private Set<Integer> hashSet;
    private Set<Integer> linkedHashSet;
    private Set<String> treeSet;

    @BeforeEach
    void setUp() {
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
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

    @Test
    void treeSetTest() {
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("2");
        treeSet.add("1");

        System.out.println("treeSet = " + treeSet);

        // 정렬 상태로 저장: 기본은 오름차순
        assertThat(treeSet).containsExactly("1", "2", "A", "B", "C");

        // 비교자(Comparator)를 넘겨 내림차순으로 저장
        Set<String> reverseTreeSet = new TreeSet<>(Collections.reverseOrder());
        reverseTreeSet.add("C");
        reverseTreeSet.add("B");
        reverseTreeSet.add("A");
        reverseTreeSet.add("2");
        reverseTreeSet.add("1");
        System.out.println("reverseTreeSet = " + reverseTreeSet);
        assertThat(reverseTreeSet).containsExactly("C", "B", "A", "2", "1");
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
