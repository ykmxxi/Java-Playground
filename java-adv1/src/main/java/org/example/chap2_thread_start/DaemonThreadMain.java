package org.example.chap2_thread_start;

public class DaemonThreadMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 사용자(user) 스레드 ===");
        startThread(false); // setDaemon(false) 설정이 없어도 스레드는 생성 시 기본으로 사용자 스레드

        System.out.println("===================");

        Thread.sleep(2_000L); // 2초 대기

        System.out.println("=== 데몬(daemon) 스레드 ===");
        startThread(true); // 데몬 스레드가 종료되지 않아도 Java 프로그램이 종료됨
    }

    private static void startThread(final boolean isDaemon) {
        System.out.println(Thread.currentThread().getName() + " 스레드: 시작"); // main

        System.out.println(Thread.currentThread().getName() + " 스레드: start() 전"); // main
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(isDaemon);
        daemonThread.start();

        System.out.println(Thread.currentThread().getName() + " 스레드: start() 후"); // main

        System.out.println(Thread.currentThread().getName() + " 스레드: 종료"); // main
    }

}
