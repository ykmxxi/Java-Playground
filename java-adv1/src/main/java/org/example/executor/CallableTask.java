package org.example.executor;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    private final String name;
    private int sleepMs;

    public CallableTask(final String name) {
        this.name = name;
    }

    public CallableTask(final String name, final int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public Integer call() throws Exception {
        log(name + " 실행");
        sleep(sleepMs);
        log(name + " 완료");
        return sleepMs;
    }

}
