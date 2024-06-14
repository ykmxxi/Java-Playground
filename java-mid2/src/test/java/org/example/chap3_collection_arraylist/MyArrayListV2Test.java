package org.example.chap3_collection_arraylist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyArrayListV2Test {

    @Test
    void test() {
        MyArrayListV2 list = new MyArrayListV2(3);

        list.add("a");
        list.add("b");
        list.add("c");

        // 배열의 크기 초과 상황 발생 -> 동적 배열로 크기를 늘림
        list.add("d");
        assertThat(list.size()).isEqualTo(4);
    }

}
