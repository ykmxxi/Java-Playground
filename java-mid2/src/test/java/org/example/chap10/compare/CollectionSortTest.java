package org.example.chap10.compare;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class CollectionSortTest {

    @Test
    void listSort() {
        MyUser userB = new MyUser("b", 30);
        MyUser userA = new MyUser("a", 20);
        MyUser userC = new MyUser("c", 10);

        List<MyUser> users = new ArrayList<>();
        users.add(userB);
        users.add(userA);
        users.add(userC);

        // Collections.sort(users);
        users.sort(null); // 기본 정렬
        assertThat(users).containsExactly(userC, userA, userB);
        System.out.println(users);

        users.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        assertThat(users).containsExactly(userA, userB, userC);
        System.out.println(users);
    }

    @Test
    void treeSort() {
        MyUser userB = new MyUser("b", 30);
        MyUser userA = new MyUser("a", 20);
        MyUser userC = new MyUser("c", 10);

        TreeSet<MyUser> treeSet = new TreeSet<>();
        treeSet.add(userB);
        treeSet.add(userA);
        treeSet.add(userC);

        assertThat(treeSet.toArray()).containsExactly(userC, userA, userB);

        treeSet = new TreeSet<>((o1, o2) -> o1.getId().compareTo(o2.getId()));
        treeSet.add(userB);
        treeSet.add(userA);
        treeSet.add(userC);

        assertThat(treeSet.toArray()).containsExactly(userA, userB, userC);
    }

}
