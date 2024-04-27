package org.example.chap2;

public class ImmutableObject {

    private final int value;

    public ImmutableObject(final int value) {
        this.value = value;
    }

    public ImmutableObject add(final int addValue) {
        return new ImmutableObject(value + addValue);
    }

    public int getValue() {
        return value;
    }

}
