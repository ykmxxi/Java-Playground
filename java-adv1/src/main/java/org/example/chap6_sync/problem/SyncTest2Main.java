package org.example.chap6_sync.problem;

import static org.example.util.MyLogger.log;

public class SyncTest2Main {

    public static void main(String[] args) {
        MyCounter counter = new MyCounter();

        Runnable task = counter::count;

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        thread1.start();
        thread2.start();
    }

    static class MyCounter {

        public void count() {
            int localValue = 0; // 지역 변수는 공유 자원이 아님, 각 스택 프레임에 존재
            for (int i = 0; i < 1000; i++) {
                localValue++;
            }
            log("결과: " + localValue);
        }

    }

}
