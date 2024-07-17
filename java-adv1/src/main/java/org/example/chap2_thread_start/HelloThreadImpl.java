package org.example.chap2_thread_start;

public class HelloThreadImpl implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 스레드: run()");
    }

}
