package org.example.bounded;

import static org.example.util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 스레드 대기시 즉시 반환
public class BoundedQueueV6_2 implements BoundedQueue {

    private final BlockingQueue<String> queue;

    public BoundedQueueV6_2(final int max) {
        queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(final String data) {
        boolean result = queue.offer(data);
        log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
