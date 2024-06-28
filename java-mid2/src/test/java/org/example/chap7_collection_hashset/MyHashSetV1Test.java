package org.example.chap7_collection_hashset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyHashSetV1Test {

    @Test
    void test() {
        MyHashSetV1 set = new MyHashSetV1(10);
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(8);
        set.add(14);
        set.add(99);
        set.add(9); // hash collision
        set.add(1); // 중복 값

        assertThat(set.size()).isEqualTo(7);
        assertThat(set.contains(9)).isTrue();

        set.remove(9);
        assertThat(set.size()).isEqualTo(6);
        assertThat(set.contains(9)).isFalse();
        System.out.println(set);
    }

}
