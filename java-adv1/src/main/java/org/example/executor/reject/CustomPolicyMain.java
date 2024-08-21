package org.example.executor.reject;

import static org.example.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.example.executor.RunnableTask;

public class CustomPolicyMain {

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new MyRejectedExecutionHandler());

        es.submit(new RunnableTask("task1"));
        es.submit(new RunnableTask("task2"));
        es.submit(new RunnableTask("task3"));

        es.close();
    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        static AtomicInteger count = new AtomicInteger();

        @Override
        public void rejectedExecution(final Runnable r, final ThreadPoolExecutor executor) {
            int i = count.incrementAndGet();
            log("[Warning] 거절된 누적 작업 수: " + i);
        }

    }

}
