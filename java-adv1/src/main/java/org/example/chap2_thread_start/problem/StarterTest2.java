package org.example.chap2_thread_start.problem;

import static org.example.util.MyLogger.log;

public class StarterTest2 {

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintWork("A", 1_000L), "Thread-A");
        Thread threadB = new Thread(new PrintWork("B", 500L), "Thread-B");

        threadA.start();
        threadB.start();
    }

    static class PrintWork implements Runnable {

        private final String content;
        private final Long waitingTime;

        public PrintWork(final String content, final Long waitingTime) {
            this.content = content;
            this.waitingTime = waitingTime;
        }

        @Override
        public void run() {
            while (true) {
                log(content);

                try {
                    Thread.sleep(waitingTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
