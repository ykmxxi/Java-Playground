package org.example.executor.poolsize;

import static org.example.executor.ExecutorUtils.printState;
import static org.example.util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.example.executor.RunnableTask;

public class CustomThreadPoolMain {

    static final int TASK_SIZE = 1100; // 일반 -> 약 12초
//    static final int TASK_SIZE = 1200; // 긴급, 초과 스레드 생성 -> 약 6초
//    static final int TASK_SIZE = 1201; // 거절, 요청 거절 발생 -> 약 6초

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(100, 200, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000));

        // 실무에서 자주 하는 실수
        // 큐의 사이즈를 무한대로 설정해 기본 스레드만 사용하는 상황 발생
        ExecutorService badEs = new ThreadPoolExecutor(100, 200, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        printState(es);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= TASK_SIZE; i++) {
            String taskName = "task" + i;
            try {
                es.execute(new RunnableTask(taskName));
                printState(es, taskName);
            } catch (RejectedExecutionException e) {
                log(taskName + e);
            }

        }
        es.close();
        long end = System.currentTimeMillis();
        log("time = " + (end - start) + "ms");
    }

}
