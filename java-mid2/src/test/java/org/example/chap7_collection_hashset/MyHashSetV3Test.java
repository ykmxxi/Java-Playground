package org.example.chap7_collection_hashset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyHashSetV3Test {

    @Test
    void test() {
        MyHashSetV3<Member> set = new MyHashSetV3<>();

        set.add(new Member("A"));
        set.add(new Member("B"));
        set.add(new Member("C"));
        set.add(new Member("A"));

        assertThat(set.size()).isEqualTo(3);

        assertThat(set.contains(new Member("A"))).isTrue();
        assertThat(set.contains(new Member("B"))).isTrue();
        assertThat(set.contains(new Member("C"))).isTrue();
    }

}
