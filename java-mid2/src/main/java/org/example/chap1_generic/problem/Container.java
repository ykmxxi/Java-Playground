package org.example.chap1_generic.problem;

public class Container<T> {

    private T item;

    public void setItem(final T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public boolean isEmpty() {
        return item == null;
    }

}
