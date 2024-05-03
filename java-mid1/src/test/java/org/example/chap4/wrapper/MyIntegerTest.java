package org.example.chap4.wrapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.Test;

class MyIntegerTest {

    @Test
    void compareTo() {
        MyInteger myInteger = new MyInteger(10);

        assertThat(myInteger.compareTo(9)).isEqualTo(1);
        assertThat(myInteger.compareTo(10)).isEqualTo(0);
        assertThat(myInteger.compareTo(11)).isEqualTo(-1);
    }

    @Test
    void findValue() {
        MyInteger[] myIntegers = {new MyInteger(-1), new MyInteger(10), new MyInteger(100)};

        assertThat(Objects.requireNonNull(findValue(myIntegers, -1)).getValue()).isEqualTo(-1);
        assertThat(findValue(myIntegers, 20)).isNull();
    }

    private MyInteger findValue(final MyInteger[] arr, final int target) {
        for (MyInteger myInteger : arr) {
            if (myInteger.compareTo(target) == 0) {
                return myInteger;
            }
        }
        return null;
    }

}
