package org.example.chap10.compare;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortTest {

    @Test
    @DisplayName("사용자 정의 객체: Comparable 인터페이스(나이를 기준으로 정렬) 구현")
    void onlyComparable() {
        MyUser userB = new MyUser("b", 30);
        MyUser userA = new MyUser("a", 20);
        MyUser userC = new MyUser("c", 10);

        MyUser[] users = {userB, userA, userC};

        Arrays.sort(users);

        assertThat(users).containsExactly(userC, userA, userB);
        System.out.println(Arrays.toString(users));
    }

    @Test
    @DisplayName("사용자 정의 객체: Comparable 인터페이스(나이 기준) 구현, Comparator(id 기준) 전달")
    void comparableWithComparator() {
        MyUser userB = new MyUser("b", 30);
        MyUser userA = new MyUser("a", 20);
        MyUser userC = new MyUser("c", 10);

        MyUser[] users = {userB, userA, userC};

        Arrays.sort(users,
                (o1, o2) -> o1.getId().compareTo(o2.getId())
        );

        // Comparator가 우선권을 갖는다
        assertThat(users).containsExactly(userA, userB, userC);
        System.out.println(Arrays.toString(users));
    }

}
