package org.example.chap4_collection_linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyLinkedListV2Test {

    @Test
    void test() {
        MyLinkedListV2 list = new MyLinkedListV2();

        list.add("a");
        list.add("b");
        list.add("c");

        list.add(0, "d");
        assertThat(list.get(0)).isEqualTo("d");
        assertThat(list.get(1)).isEqualTo("a");
        assertThat(list.size()).isEqualTo(4);

        String removed = (String) list.remove(0);
        assertThat(removed).isEqualTo("d");
        assertThat(list.get(0)).isEqualTo("a");
        assertThat(list.size()).isEqualTo(3);
    }

}
