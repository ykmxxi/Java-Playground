package org.example.chap4_thread_interrupt;

public class ThreadYieldMain {

    private static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);

                // empty // 1. OS의 스레드 스케줄링에 따르기
                // sleep(1L); // 2. 특정 스레드를 잠시 쉬게 만들기
                Thread.yield(); // 3. 다른 스레드에 실행을 양보
            }
        }

    }

}
