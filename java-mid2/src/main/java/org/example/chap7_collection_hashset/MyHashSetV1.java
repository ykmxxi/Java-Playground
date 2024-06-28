package org.example.chap7_collection_hashset;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV1 {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private LinkedList<Integer>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV1() {
        initBuckets();
    }

    public MyHashSetV1(final int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(final int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(final int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(value);
    }

    public boolean remove(final int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        // 객체 타입으로 넘겨야 Object(값) 제거, 숫자 타입으로 넘기면 index로 인식
        boolean removed = bucket.remove(Integer.valueOf(value));
        if (removed) {
            size--;
            return true;
        }
        return false;
    }

    private int hashIndex(final int value) {
        return value % capacity;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

}
