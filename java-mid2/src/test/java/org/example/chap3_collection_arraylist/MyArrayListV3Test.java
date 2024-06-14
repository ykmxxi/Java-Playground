package org.example.chap3_collection_arraylist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyArrayListV3Test {

    @Test
    void test() {
        MyArrayListV3 list = new MyArrayListV3();

        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");

        list.add(2, "20"); // index 2 위치에 20을 추가
        assertThat(list.get(2)).isEqualTo("20");
        assertThat(list.get(3)).isEqualTo("2");
        assertThat(list.size()).isEqualTo(5);

        assertThat(list.remove(0)).isEqualTo("0");
        assertThat(list.get(0)).isEqualTo("1");
        assertThat(list.get(1)).isEqualTo("20");
        assertThat(list.size()).isEqualTo(4);

        System.out.println(list);
    }

}
