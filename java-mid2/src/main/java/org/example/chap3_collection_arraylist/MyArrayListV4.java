package org.example.chap3_collection_arraylist;

import java.util.Arrays;

/**
 * ArrayList: 제네릭 도입
 * 타입 안전성, 위험한 다운 캐스팅 방지
 */
public class MyArrayListV4<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData; // 다양한 데이터 타입을 보관하기 위해 Object
    private int size = 0; // 리스트의 크기

    public MyArrayListV4() { // 기본 생성자, DEFAULT_CAPACITY 사용
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV4(final int initialCapacity) { // 리스트의 시작 크기를 입력 받음
        this.elementData = new Object[initialCapacity];
    }

    public int size() { // 리스트의 크기를 반환
        return size;
    }

    public void add(final E e) { // 데이터 추가
        // 동적 배열: size가 capacity를 초과하는 경우 배열의 크기를 늘린다
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = e;
    }

    // index 위치에 데이터를 추가
    public void add(final int index, final E e) {
        if (size == elementData.length) {
            grow();
        }
        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // 요소의 마지막부터 index까지 오른쪽으로 밀기
    private void shiftRightFrom(final int index) {
        // 왼쪽에 있는 값을 오른쪽으로 한 칸씩 땡겨오기
        for (int idx = size; idx > index; idx--) {
            elementData[idx] = elementData[idx - 1];
        }
    }

    // index 위치의 데이터를 삭제
    public E remove(final int index) {
        E removedValue = get(index);
        shiftLeftFrom(index);

        size--;
        elementData[size] = null;
        return removedValue;
    }

    // index부터 마지막까지 왼쪽으로 밀기
    private void shiftLeftFrom(final int index) {
        // 오른쪽에 위치한 값을 왼쪽으로 한 칸씩 땡겨오기
        for (int idx = index; idx < size - 1; idx++) {
            elementData[idx] = elementData[idx + 1];
        }
    }

    public E get(final int index) { // 데이터 조회
        return (E) elementData[index];
    }

    public E set(final int index, final E e) { // 인덱스 항목에 있는 데이터 변경
        E oldValue = get(index);
        elementData[index] = e;
        return oldValue;
    }

    public int indexOf(final E e) { // 해당 데이터의 인덱스 반환, 없으면 -1
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
