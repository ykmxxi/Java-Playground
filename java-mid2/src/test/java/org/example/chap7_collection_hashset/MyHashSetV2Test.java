package org.example.chap7_collection_hashset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("직접 만든 객체(사용자 정의 타입): equals & hashcode 반드시 구현")
    void 직접_만든_객체_저장() {
        Member hi = new Member("hi");
        Member jpa = new Member("JPA");
        Member java = new Member("java");
        Member spring = new Member("spring");

        MyHashSetV2 set = new MyHashSetV2(10);
        set.add(hi);
        set.add(jpa);
        set.add(java);
        set.add(spring);

        System.out.println(set);

        assertThat(set.contains(new Member("JPA"))).isTrue();
    }

}
