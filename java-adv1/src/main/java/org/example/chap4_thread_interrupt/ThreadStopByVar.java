package org.example.chap4_thread_interrupt;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class ThreadStopByVar {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4_000L);
        log("작업 중단 지시 runFlag = false");
        task.runFlag = false;
    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                log("작업 중");
                sleep(3_000L);
            }
            log("자원 정리");
            log("작업 종료");
        }

    }

}
