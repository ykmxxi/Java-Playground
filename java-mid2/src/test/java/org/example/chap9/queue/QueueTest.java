package org.example.chap9.queue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    @DisplayName("Queue: FIFO 구조")
    void queue() {
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertThat(queue.peek()).isEqualTo(1);

        assertThat(queue.poll()).isEqualTo(1);
        assertThat(queue.poll()).isEqualTo(2);
        assertThat(queue.poll()).isEqualTo(3);
    }

    @Test
    @DisplayName("Deque: Double Ended Queue, 큐와 스택 모두 활용 가능")
    void deque() {
        Deque<Integer> dq = new ArrayDeque<>();
        // Deque<Integer> dq = new LinkedList<>(); // ArrayDeque가 훨씬 성능이 좋음

        // Stack 활용 시 push() 또는 offerFirst()로 삽입, pop() 또는 pollFirst()로 뽑기
        dq.push(1);
        dq.push(2);
        dq.push(3);
        System.out.println(dq); // [3 , 2, 1]

        assertThat(dq.pop()).isEqualTo(3);
        assertThat(dq.pop()).isEqualTo(2);
        assertThat(dq.pop()).isEqualTo(1);

        dq.offerFirst(1);
        dq.offerFirst(2);
        dq.offerFirst(3);
        System.out.println(dq);
        assertThat(dq.pollFirst()).isEqualTo(3);
        assertThat(dq.pollFirst()).isEqualTo(2);
        assertThat(dq.pollFirst()).isEqualTo(1);

        // Queue로 활용 시 offer() 또는 offerLast()로 삽입, poll() 또는
        dq.offer(1);
        dq.offer(2);
        dq.offer(3);
        System.out.println(dq); // [1, 2, 3]
        assertThat(dq.poll()).isEqualTo(1);
        assertThat(dq.poll()).isEqualTo(2);
        assertThat(dq.poll()).isEqualTo(3);

        dq.offerLast(1);
        dq.offerLast(2);
        dq.offerLast(3);
        System.out.println(dq); // [1, 2, 3]
        assertThat(dq.pollFirst()).isEqualTo(1);
        assertThat(dq.pollFirst()).isEqualTo(2);
        assertThat(dq.pollFirst()).isEqualTo(3);
    }

}
