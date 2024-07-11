package org.example.chap10.iterable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class MyArrayTest {

    @Test
    void test() {
        MyArray array = new MyArray(new int[]{1, 2, 3, 4, 5});

        Iterator<Integer> iterator = array.iterator();

        int expected = 1;
        int cnt = 0;
        while (iterator.hasNext()) {
            assertThat(iterator.next()).isEqualTo(expected);
            expected++;
            cnt++;
        }

        assertThat(cnt).isEqualTo(5);
    }

}
