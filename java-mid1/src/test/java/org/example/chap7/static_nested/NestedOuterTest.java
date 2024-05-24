package org.example.chap7.static_nested;

import org.example.chap7.static_nested.NestedOuter.Nested;
import org.junit.jupiter.api.Test;

class NestedOuterTest {

    @Test
    void test() {
        // 없어도 무관함, 중첩 내부 클래스 Nested와 아무런 관계가 없음
        NestedOuter nestedOuter = new NestedOuter();

        Nested nested = new Nested();
        nested.print();

        // class org.example.chap7.static_nested.NestedOuter$Nested
        System.out.println(nested.getClass());
    }

}
