package org.example.chap1_generic.problem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PairTest {

    @Test
    void test() {
        Pair<Integer, String> pair1 = new Pair<>();
        pair1.setFirst(1);
        pair1.setSecond("data1");

        assertThat(pair1.getFirst()).isEqualTo(1);
        assertThat(pair1.getSecond()).isEqualTo("data1");

        Pair<String, String> pair2 = new Pair<>();
        pair2.setFirst("key");
        pair2.setSecond("value");

        assertThat(pair2.getFirst()).isEqualTo("key");
        assertThat(pair2.getSecond()).isEqualTo("value");

        System.out.println(pair1);
        System.out.println(pair2);
    }

}
