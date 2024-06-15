package org.example.chap3_collection_arraylist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyArrayListV4Test {

    @Test
    void 타입_안전성() {
        MyArrayListV4<Integer> integerList = new MyArrayListV4<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        // integerList.add("A"); // 컴파일 에러

        // 다운 캐스팅 필요 X
        assertThat(integerList.get(0)).isExactlyInstanceOf(Integer.class);
    }

}
