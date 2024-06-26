package org.example.chap6_collection_hash;

import java.util.Arrays;

/**
 * Hash Algorithm: 나머지 연산 적용
 * 해시 인덱스(Hash Index)를 사용해 메모리 공간을 절약하고, 저장과 조회 성능을 O(1)로 끌어올림
 * 단, 해시 충돌(Hash Collision) 문제가 존재
 */
public class HashStart3 {

    private static final int CAPACITY = 10;

    public static void main(String[] args) {
        Integer[] elementData = new Integer[CAPACITY];

        add(elementData, 1);
        add(elementData, 2);
        add(elementData, 5);
        add(elementData, 8);
        add(elementData, 14);
        add(elementData, 99);

        System.out.println(Arrays.toString(elementData));

        int findValue = 14;
        int hashIndex = hashIndex(findValue);
        System.out.println(elementData[hashIndex]);
    }

    private static void add(final Integer[] elementData, final int value) {
        elementData[hashIndex(value)] = value;
    }

    private static int hashIndex(final int value) {
        return value % CAPACITY;
    }

}
