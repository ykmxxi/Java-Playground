package org.example.chap7.inner;

import org.junit.jupiter.api.Test;

class InnerOuterTest {

    @Test
    void test() {
        InnerOuter innerOuter = new InnerOuter();
        InnerOuter.Inner inner = innerOuter.new Inner();

        inner.print();

        System.out.println(inner.getClass());
    }

}
