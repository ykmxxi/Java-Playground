package org.example.chap6_collection_hash;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyHashSetV0Test {

    @Test
    void myHashSetTest() {
        MyHashSetV0 myHashSet = new MyHashSetV0();

        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);

        assertThat(myHashSet.add(1)).isFalse();

        assertThat(myHashSet.size()).isEqualTo(3);

        assertThat(myHashSet.contains(1)).isTrue();
        assertThat(myHashSet.contains(2)).isTrue();
        assertThat(myHashSet.contains(3)).isTrue();
        assertThat(myHashSet.contains(4)).isFalse();
    }

}
