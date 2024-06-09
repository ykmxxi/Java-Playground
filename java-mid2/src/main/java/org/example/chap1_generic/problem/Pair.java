package org.example.chap1_generic.problem;

public class Pair<K, V> {

    private K first;
    private V second;

    public void setFirst(final K first) {
        this.first = first;
    }

    public void setSecond(final V second) {
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

}
