package org.example.bounded;

import static org.example.util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// 스레드 특정 시간동안 대기
public class BoundedQueueV6_3 implements BoundedQueue {

    private final BlockingQueue<String> queue;

    public BoundedQueueV6_3(final int max) {
        queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(final String data) {
        try {
            boolean result = queue.offer(data, 1L, TimeUnit.NANOSECONDS);
            log("저장 시도 결과 = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {
            return queue.poll(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
