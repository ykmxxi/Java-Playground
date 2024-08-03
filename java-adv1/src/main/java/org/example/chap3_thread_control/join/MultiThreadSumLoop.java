package org.example.chap3_thread_control.join;

import static java.lang.Thread.State.TERMINATED;
import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class MultiThreadSumLoop {

    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        // sleep(3_000L);

        while ((thread1.getState() != TERMINATED) && (thread2.getState() != TERMINATED)) {
            // 무한 루프를 사용한 대기
            // 스레드가 많은 상황에서 번거롭고, CPU 연산을 사용하기 때문에 좋은 방법은 아니다
        }

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        log("sumAll = " + sumAll);
        log("End");
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result;

        public SumTask(final int startValue, final int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2_000L);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료");
        }

    }

}