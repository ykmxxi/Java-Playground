package org.example.bounded;

import static org.example.util.MyLogger.log;

public class ProducerTask implements Runnable {

    private final BoundedQueue queue;
    private final String request;

    public ProducerTask(final BoundedQueue queue, final String request) {
        this.queue = queue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[생산 시도] " + request + " -> " + queue);
        queue.put(request);
        log("[생산 완료] " + request + " -> " + queue);
    }

}
