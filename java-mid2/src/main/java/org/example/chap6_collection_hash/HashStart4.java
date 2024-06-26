package org.example.chap6_collection_hash;

import java.util.LinkedList;

/**
 * Hash Algorithm: 해시 충돌 해결
 * 해시 인덱스(Hash Index)를 사용해 메모리 공간을 절약하고, 저장과 조회 성능을 평균 O(1)로 끌어올림
 * 최악의 경우 O(n)이지만 확률은 매우 낮음
 */
public class HashStart4 {

    private static final int CAPACITY = 10;

    public static void main(String[] args) {
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }

        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9);

        for (int i = 0; i < buckets.length; i++) {
            System.out.println("buckets[" + i + "] = " + buckets[i]);
        }

        System.out.println("contains(99) = " + contains(buckets, 99));
        System.out.println("contains(9) = " + contains(buckets, 9));
        System.out.println("contains(1) = " + contains(buckets, 1));
        System.out.println("contains(3) = " + contains(buckets, 3));
    }

    private static void add(final LinkedList<Integer>[] buckets, final int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if (!bucket.contains(value)) { // 최악의 경우 O(n)
            bucket.add(value);
        }
    }

    private static boolean contains(final LinkedList<Integer>[] buckets, final int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(value); // 최악의 경우 O(n)
    }

    private static int hashIndex(final int value) {
        return value % CAPACITY;
    }

}
