package org.example.chap5_volatile;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class NonVolatileMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("task.runFlag = " + task.runFlag);
        t.start();

        sleep(1_000L);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("task.runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {

        boolean runFlag = true; // CPU 캐시 메모리에 저장된 값에 접근

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // 작업 중
                // runFlag = false, 무한루프 탈출
            }
            log("task 종료");
        }

    }

}
