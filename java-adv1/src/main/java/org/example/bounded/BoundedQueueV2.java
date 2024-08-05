package org.example.bounded;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV2 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(final int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(final String data) {
        while (queue.size() == max) {
            log("[put] 큐가 가득 참, 생산자 대기");
            sleep(1_000L);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기");
            sleep(1_000L);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
