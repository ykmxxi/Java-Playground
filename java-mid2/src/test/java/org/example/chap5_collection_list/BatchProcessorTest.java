package org.example.chap5_collection_list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BatchProcessorTest {

    @Test
    @DisplayName("의존관계 주입(Dependency Injection, DI): 실행 시점에 구체 클래스를 결정")
    void 의존관계_주입() {
        BatchProcessor arrayListProcessor = new BatchProcessor(new MyArrayList<>());
        BatchProcessor linkedListProcessor = new BatchProcessor(new MyLinkedList<>());

        int size = 50_000;
        long arrayListResult = arrayListProcessor.logic(size); // 3326ms
        long linkedListResult = linkedListProcessor.logic(size); // 5ms

        // 데이터를 제일 앞에 추가하는 작업은 LinkedList: O(1), ArrayList: O(n)
        assertThat(linkedListResult).isLessThan(arrayListResult);
    }

}
