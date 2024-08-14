package org.example.executor;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.Random;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join();
        int result = task.value();
        log("result value = " + result);
    }

    static class MyRunnable implements Runnable {

        private int value;

        @Override
        public void run() {
            log("Runnable 시작");
            sleep(2_000L);
            value = new Random().nextInt(10);
            log("create value = " + value);
            log("Runnable 종료");
        }

        public int value() {
            return value;
        }

    }

}
