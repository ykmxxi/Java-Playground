package org.example.executor.future;

import static org.example.util.MyLogger.log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BadCallableTaskMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Future 잘못 사용한 예제1: 요청을 1개씩 보내고 결과 요청
        long start = System.currentTimeMillis();
        Future<Integer> future1 = executorService.submit(task1);
        Integer sum1 = future1.get();
        Future<Integer> future2 = executorService.submit(task2);
        Integer sum2 = future2.get();
        long end = System.currentTimeMillis();
        log("소요 시간 = " + (end - start) + "ms"); // 약 4000ms, 4초

        // Future 잘못 사용한 예제2: Future 객체없이 바로 결과 요청
        start = System.currentTimeMillis();
        Integer sum3 = executorService.submit(task1).get();
        Integer sum4 = executorService.submit(task2).get();
        end = System.currentTimeMillis();
        log("소요 시간 = " + (end - start) + "ms"); // 약 4000ms, 4초

        log("task1.result = " + sum1);
        log("task2.result = " + sum2);
        int sumAll = sum1 + sum2;
        log("task1 + task2 = " + sumAll);
        log("End");
        executorService.close();
    }

    static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;

        public SumTask(final int startValue, final int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {
            log("작업 시작");
            Thread.sleep(2000);

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            log("작업 완료 result=" + sum);
            return sum;
        }

    }

}
