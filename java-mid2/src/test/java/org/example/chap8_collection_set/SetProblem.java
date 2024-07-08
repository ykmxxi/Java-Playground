package org.example.chap8_collection_set;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetProblem {

    @Test
    @DisplayName("입력된 배열에서 중복 값을 제거하고 출력")
    void problem1() {
        Integer[] inputArr = {30, 20, 20, 10, 10};

        Set<Integer> set = new HashSet<>(List.of(inputArr));
        set.forEach(System.out::println);
    }

    @Test
    @DisplayName("중복 값을 제거하고 값을 출력, 단 입력 순서대로 출력")
    void problem2() {
        Integer[] inputArr = {30, 20, 20, 10, 10};

        Set<Integer> set = new LinkedHashSet<>(List.of(inputArr));
        set.forEach(System.out::println);
        assertThat(set).containsExactly(30, 20, 10);
    }

    @Test
    @DisplayName("중복 값을 제거하고 값을 출력, 단 오름차순으로 출력")
    void problem3() {
        Integer[] inputArr = {30, 20, 20, 10, 10};

        Set<Integer> set = new TreeSet<>(List.of(inputArr));
        set.forEach(System.out::println);
        assertThat(set).containsExactly(10, 20, 30);
    }

    @Test
    @DisplayName("두 숫자 집합이 주어질 때 합집합, 교집합, 차집합을 구한다")
    void problem4() {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        // 합집합
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        assertThat(unionSet).contains(1, 2, 3, 4, 5, 6, 7);
        System.out.println("unionSet = " + unionSet);

        // 교집합
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        assertThat(intersectionSet).contains(3, 4, 5);
        System.out.println("intersectionSet = " + intersectionSet);

        // 차집합
        Set<Integer> diffSet = new HashSet<>(set1);
        diffSet.removeAll(set2);
        assertThat(diffSet).contains(1, 2);
        System.out.println("diffSet = " + diffSet);
    }

    @Test
    void problem5() {
        Set<Rectangle> rectangles = new HashSet<>();
        rectangles.add(new Rectangle(10, 10));
        rectangles.add(new Rectangle(20, 20));
        rectangles.add(new Rectangle(20, 20));

        assertThat(rectangles.size()).isEqualTo(2);
        rectangles.forEach(System.out::println);
    }

}
