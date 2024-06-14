package org.example.chap3_collection_arraylist;

import java.util.Arrays;

/**
 * ArrayList: 기본, 정적인 배열을 활용
 */
public class MyArrayListV1 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData; // 다양한 데이터 타입을 보관하기 위해 Object
    private int size = 0; // 리스트의 크기

    public MyArrayListV1() { // 기본 생성자, DEFAULT_CAPACITY 사용
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV1(final int initialCapacity) { // 리스트의 시작 크기를 입력 받음
        this.elementData = new Object[initialCapacity];
    }

    public int size() { // 리스트의 크기를 반환
        return size;
    }

    public void add(final Object e) { // 데이터 추가
        elementData[size++] = e;
    }

    public Object get(final int index) { // 데이터 조회
        return elementData[index];
    }

    public Object set(final int index, final Object e) { // 인덱스 항목에 있는 데이터 변경
        Object oldValue = get(index);
        elementData[index] = e;
        return oldValue;
    }

    public int indexOf(final Object e) { // 해당 데이터의 인덱스 반환, 없으면 -1
        for (int i = 0; i < size; i++) {
            if (e.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size))
                + ", size = " + size
                + ", capacity = " + elementData.length;
    }

}
