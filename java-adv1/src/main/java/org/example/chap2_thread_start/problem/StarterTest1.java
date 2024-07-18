package org.example.chap2_thread_start.problem;

import static org.example.util.MyLogger.log;

public class StarterTest1 {

    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();

        Thread counterRunnable = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                log("value: " + i);
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        counterRunnable.start();
    }

    static class CounterThread extends Thread {

        @Override
        public void run() {
            for (int i = 1; i < 6; i++) {
                log("value: " + i);
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
