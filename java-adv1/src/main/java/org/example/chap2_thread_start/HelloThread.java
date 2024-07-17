package org.example.chap2_thread_start;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 스레드: run()");
    }

}
