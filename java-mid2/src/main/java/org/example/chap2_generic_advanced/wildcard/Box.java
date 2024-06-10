package org.example.chap2_generic_advanced.wildcard;

public class Box<T> {

    private T value;

    public void setValue(final T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

}
