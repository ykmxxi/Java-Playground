package org.example.executor.reject;

import static org.example.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.example.executor.RunnableTask;

public class AbortPolicyMain {

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());

        es.submit(new RunnableTask("task1"));
        try {
            es.submit(new RunnableTask("task2"));
        } catch (RejectedExecutionException e) {
            log("요청 초과");
            // 포기, 다시 시도 등 처리 로직
            log(e);
        }
        es.close();
    }

}
