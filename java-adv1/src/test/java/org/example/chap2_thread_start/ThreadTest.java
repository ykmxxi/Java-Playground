package org.example.chap2_thread_start;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreadTest {

    @Test
    @DisplayName("Thread 생성: Thread는 start() 호출 후 별도의 스택을 생성")
    void threadTest() {
        System.out.println(Thread.currentThread().getName() + " 스레드: 시작"); // main

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " 스레드: start() 호출 전"); // main
        helloThread.start(); // Thread-0
        System.out.println(Thread.currentThread().getName() + " 스레드: start() 호출 후"); // main

        System.out.println(Thread.currentThread().getName() + " 스레드: 종료"); // main
    }

    @Test
    @DisplayName("Thread.run(): 별도의 스레드가 생성되지 않고 main에서 호출")
    void threadRun() {
        System.out.println(Thread.currentThread().getName() + " 스레드: 시작"); // main

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " 스레드: run() 호출 전"); // main
        helloThread.run(); // main
        System.out.println(Thread.currentThread().getName() + " 스레드: run() 호출 후"); // main

        System.out.println(Thread.currentThread().getName() + " 스레드: 종료"); // main

        assertThat(Thread.currentThread().getName()).isEqualTo(helloThread.getName());
    }

    @Test
    @DisplayName("Thread 생성: Runnable 인터페이스 구현, Thread 클래스에 구현체를 전달해 생성")
    void threadImpl() {
        System.out.println(Thread.currentThread().getName() + " 스레드: 시작"); // main

        Thread helloThreadImpl = new Thread(new HelloThreadImpl());
        System.out.println(Thread.currentThread().getName() + " 스레드: start() 호출 전"); // main
        helloThreadImpl.start();
        System.out.println(Thread.currentThread().getName() + " 스레드: start() 호출 후"); // main

        System.out.println(Thread.currentThread().getName() + " 스레드: 종료"); // main
    }

}
