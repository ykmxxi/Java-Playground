package org.example.chap1_generic;

public class GenericBox<T> {

    private T value;

    public void setValue(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
