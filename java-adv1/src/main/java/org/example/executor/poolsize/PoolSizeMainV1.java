package org.example.executor.poolsize;

import static org.example.executor.ExecutorUtils.printState;
import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.example.executor.RunnableTask;

public class PoolSizeMainV1 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000L, TimeUnit.MILLISECONDS, workQueue);
        printState(es);

        es.execute(new RunnableTask("task1"));
        printState(es, "task1");
        es.execute(new RunnableTask("task2")); // 기본 스레드 2개가 모두 찬다
        printState(es, "task2");
        es.execute(new RunnableTask("task3"));
        printState(es, "task3");
        es.execute(new RunnableTask("task4")); // 작업 큐가 모두 찬다
        printState(es, "task4");
        es.execute(new RunnableTask("task5")); // 기본 스레드, 작업 큐가 모두 차 초과 스레드 생성
        printState(es, "task5");
        es.execute(new RunnableTask("task6"));
        printState(es, "task6");

        // 기본 스레드, 작업 큐, 초과 스레드가 모두 차서 실행 거절 예외가 발생
        try {
            es.execute(new RunnableTask("task7"));
            printState(es, "task7");
        } catch (RejectedExecutionException e) {
            log("task7 실행 거절 예외 발생: " + e);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);
        sleep(3000);
        log("== maximumPoolSize 대기 시간(3초) 초과 ==");
        printState(es);
        es.close();
        log("== shutdown 완료 ==");
        printState(es);
    }

}
