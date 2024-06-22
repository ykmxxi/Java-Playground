package org.example.chap5_collection_list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyListPerformanceTest {

    private final int size = 50_000;
    private MyArrayList<Integer> arrayList;
    private MyLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        arrayList = new MyArrayList<>();
        linkedList = new MyLinkedList<>();
    }

    @Test
    @DisplayName("데이터 앞에 추가: LinkedList 빠름")
    void 앞에_추가() {
        long arrayListRes = addFirst(arrayList);
        long linkedListRes = addFirst(linkedList);

        assertThat(linkedListRes).isLessThan(arrayListRes);
    }

    @Test
    @DisplayName("데이터 중간에 추가: ArrayList 빠름")
    void 평균_추가() {
        long arrayListRes = addMid(arrayList);
        long linkedListRes = addMid(linkedList);

        // 이론상 LinkedList가 효율적일 수 있지만, 메모리 접근과 CPU 캐시 효율 때문에 ArrayList 빠름
        assertThat(arrayListRes).isLessThan(linkedListRes);
    }

    @Test
    @DisplayName("데이터 뒤에 추가: ArrayList 빠름")
    void 뒤에_추가() {
        long arrayListRes = addLast(arrayList);
        long linkedListRes = addLast(linkedList);

        assertThat(arrayListRes).isLessThan(linkedListRes);
    }

    @Test
    @DisplayName("인덱스 조회: ArrayList 빠름")
    void 인덱스_조회() {
        addLast(arrayList);
        addLast(linkedList);

        int loop = 10_000;
        getIndex(arrayList, loop, 0);
        getIndex(arrayList, loop, size / 2);
        getIndex(arrayList, loop, size - 1);

        getIndex(linkedList, loop, 0);
        getIndex(linkedList, loop, size / 2);
        getIndex(linkedList, loop, size - 1);
    }

    @Test
    @DisplayName("데이터 검색: ArrayList 빠름")
    void 데이터_검색() {
        addLast(arrayList);
        addLast(linkedList);

        int loop = 10_000;
        search(arrayList, loop, 0);
        search(arrayList, loop, size / 2);
        search(arrayList, loop, size - 1);

        search(linkedList, loop, 0);
        search(linkedList, loop, size / 2);
        search(linkedList, loop, size - 1);
    }

    private long addFirst(final MyList<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간: " + (end - start) + "ms");
        return end - start;
    }

    private long addMid(final MyList<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("평균 추가 - 크기: " + size + ", 계산 시간: " + (end - start) + "ms");
        return end - start;
    }

    private long addLast(final MyList<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("뒤에 추가 - 크기: " + size + ", 계산 시간: " + (end - start) + "ms");
        return end - start;
    }

    private void getIndex(final MyList<Integer> list, final int loop, final int index) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long end = System.currentTimeMillis();
        System.out.println("인덱스 조회 - 반복 횟수:" + loop + "회, index: " + index + ",계산 시간: " + (end - start) + "ms");
    }

    private void search(final MyList<Integer> list, final int loop, final int findValue) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long end = System.currentTimeMillis();
        System.out.println("데이터 검색 - 반복 횟수:" + loop + "회, 찾으려는 값: " + findValue + ",계산 시간: " + (end - start) + "ms");
    }

}
