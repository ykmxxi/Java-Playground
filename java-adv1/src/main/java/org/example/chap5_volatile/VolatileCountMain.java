package org.example.chap5_volatile;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        log("Volatile 미적용");
        MyTask1 task1 = new MyTask1();
        Thread t1 = new Thread(task1, "work");
        t1.start();

        sleep(1_000L);
        task1.flag = false;
        log("flag = " + task1.flag + ", count = " + task1.count + " in main"); // 629,753,161
        sleep(1_000L);
        log("Volatile 적용");

        MyTask2 task2 = new MyTask2();
        Thread t2 = new Thread(task2, "work");
        t2.start();

        sleep(1_000L);
        task2.flag = false;
        log("flag = " + task2.flag + ", count = " + task2.count + " in main"); // 153,936,597
    }

    static class MyTask1 implements Runnable {

        boolean flag = true;
        long count;

        @Override
        public void run() {
            while (flag) {
                count++;
                if (count % 100_000_000 == 0) {
                    log("flag = " + flag + ", count = " + count + " in while");
                }
            }
            log("flag = " + flag + ", count = " + count + " 종료");
        }

    }

    static class MyTask2 implements Runnable {

        volatile boolean flag = true;
        volatile long count;

        @Override
        public void run() {
            while (flag) {
                count++;
                if (count % 100_000_000 == 0) {
                    log("flag = " + flag + ", count = " + count + " in while");
                }
            }
            log("flag = " + flag + ", count = " + count + " 종료");
        }

    }

}
