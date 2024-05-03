package org.example.chap4.wrapper;

public class MyInteger {

    private final int value;

    public MyInteger(final int value) {
        this.value = value;
    }

    public int compareTo(final int target) {
        if (value < target) {
            return -1;
        }
        if (value > target) {
            return 1;
        }
        return 0;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
