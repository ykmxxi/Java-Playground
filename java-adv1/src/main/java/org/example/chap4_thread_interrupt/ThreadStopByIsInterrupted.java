package org.example.chap4_thread_interrupt;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class ThreadStopByIsInterrupted {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100L);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
            try {
                log("자원 정리 시도");
                Thread.sleep(1_000L); // 인터럽트 상태가 유지되어 sleep() 호출 시 예외를 던짐
                log("자원 정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                // 예외가 터져 Java가 다시 정상(false)로 되돌린다
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
        }

    }

}
