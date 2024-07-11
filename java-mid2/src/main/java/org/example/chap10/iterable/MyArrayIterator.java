package org.example.chap10.iterable;

import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> {

    private int currentIndex = -1; // -1 시작해야 다음 인덱스를 가리킬 때 0
    private int[] targetArr; // 순회하고 싶은 배열

    public MyArrayIterator(final int[] targetArr) {
        this.targetArr = targetArr;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < targetArr.length - 1;
    }

    @Override
    public Integer next() {
        return targetArr[++currentIndex];
    }

}
