package org.example.chap2_thread_start;

public class DaemonThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 스레드: run() start");

        try {
            Thread.sleep(5_000L); // 5초 대기
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " 스레드: run() end");
    }

}
