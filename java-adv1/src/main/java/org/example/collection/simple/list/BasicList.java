package org.example.collection.simple.list;

import static org.example.util.ThreadUtils.sleep;

import java.util.Arrays;

public class BasicList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public BasicList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(final Object e) {
        // 원자적인 연산이 아님
        // 1. 데이터 저장
        elementData[size] = e;
        sleep(100L);
        // 2. 사이즈 증가 -> size = size + 1, 2번 과정도 3개의 연산으로 이루어짐
        size++;
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size))
                + " size = " + size + ", capacity = " + elementData.length;
    }

}
