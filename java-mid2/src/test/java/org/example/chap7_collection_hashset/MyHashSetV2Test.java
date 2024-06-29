package org.example.chap7_collection_hashset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyHashSetV2Test {

    @Test
    void test() {
        MyHashSetV2 set = new MyHashSetV2();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("AB");
        set.add("SET");
        System.out.println("set = " + set);
        System.out.println("A.hashCode() = " + "A".hashCode());
        System.out.println("SET.hashCode() = " + "SET".hashCode());

        assertThat(set.contains("A")).isTrue();
        assertThat(set.contains("SET")).isTrue();
        assertThat(set.size()).isEqualTo(6);

        set.add("SET");
        assertThat(set.size()).isEqualTo(6);
    }

}
