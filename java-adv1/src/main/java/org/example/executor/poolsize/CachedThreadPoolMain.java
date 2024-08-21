package org.example.executor.poolsize;

import static org.example.executor.ExecutorUtils.printState;
import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.example.executor.RunnableTask;

public class CachedThreadPoolMain {

    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3L, TimeUnit.SECONDS,
                new SynchronousQueue<>());

        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 4; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }

        sleep(3000L);
        log("== 작업 수행 완료 ==");
        printState(es);

        sleep(3000L);
        log("== maximumPoolSize 대기 시간 초과 ==");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
    }

}
