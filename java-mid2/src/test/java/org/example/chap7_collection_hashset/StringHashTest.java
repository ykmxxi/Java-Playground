package org.example.chap7_collection_hashset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringHashTest {

    @Test
    void charToInt() {
        char charA = 'A';
        char charB = 'B';

        assertThat((int) charA).isEqualTo(65);
        assertThat((int) charB).isEqualTo(66);
    }

    @Test
    void hashCodeTest() {
        assertThat(StringHash.hashCode("AB")).isEqualTo(65 + 66);
    }

}
