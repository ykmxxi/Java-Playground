package chap02.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private Object[] elements; // 저장소 풀의 size를 직접 늘리고 줄여 메모리 직접 관리 -> 메모리 누수의 원인
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        // 메모리 누수(Memory Leak) 발생 가능성 존재 -> 다 쓴 참조(Obsolete Reference)를 해제하지 않음
//        return elements[--size];
        Object result = elements[--size];
        elements[size] = null; // 메모리 누수를 방지하기 위해 참조 해제
        return result;
    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
