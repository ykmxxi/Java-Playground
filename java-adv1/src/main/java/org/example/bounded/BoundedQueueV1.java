package org.example.bounded;

import static org.example.util.MyLogger.log;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV1 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max; // 한정된 큐의 최대 크기

    public BoundedQueueV1(final int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(final String data) {
        if (queue.size() == max) {
            log("[put] 큐가 가득 참, 버림: " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        return queue.isEmpty() ? null : queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
