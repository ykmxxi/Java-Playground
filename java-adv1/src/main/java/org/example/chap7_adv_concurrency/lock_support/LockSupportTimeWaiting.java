package org.example.chap7_adv_concurrency.lock_support;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTimeWaiting {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTask(), "Thread-1");
        thread1.start();

        sleep(100L);
        log("Thread-1 state: " + thread1.getState());
        // unpark() 호출이 필요없음
    }

    static class ParkTask implements Runnable {

        @Override
        public void run() {
            log("park 시작, 2초 대기");
            LockSupport.parkNanos(2_000_000_000L);
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }

    }

}
