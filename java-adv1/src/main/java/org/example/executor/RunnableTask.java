package org.example.executor;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class RunnableTask implements Runnable {

    private final String name;
    private long sleepMs;

    public RunnableTask(final String name) {
        this.name = name;
        this.sleepMs = 1_000L;
    }

    public RunnableTask(final String name, final long sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        sleep(sleepMs);
        log(name + " 종료");
    }

}
