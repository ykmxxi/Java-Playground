package org.example.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 스레드 대기시 예외
public class BoundedQueueV6_4 implements BoundedQueue {

    private final BlockingQueue<String> queue;

    public BoundedQueueV6_4(final int max) {
        queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(final String data) {
        queue.add(data); // java.lang.IllegalStateException: Queue full
    }

    @Override
    public String take() {
        return queue.remove(); // java.lang.NoSuchElementException
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
