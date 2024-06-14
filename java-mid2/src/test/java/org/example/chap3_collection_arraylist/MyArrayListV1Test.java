package org.example.chap3_collection_arraylist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyArrayListV1Test {

    @Test
    void test() {
        MyArrayListV1 list = new MyArrayListV1();

        assertThat(list.size()).isEqualTo(0);

        list.add("a");
        list.add("b");
        list.add("c");
        assertThat(list.get(2)).isEqualTo("c");
        assertThat(list.size()).isEqualTo(3);

        Object oldValue = list.set(0, "1");
        assertThat(oldValue).isEqualTo("a");
        assertThat(list.get(0)).isEqualTo("1");

        assertThat(list.indexOf("b")).isEqualTo(1);

        System.out.println(list);
    }

}
