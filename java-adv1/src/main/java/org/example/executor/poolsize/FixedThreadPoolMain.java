package org.example.executor.poolsize;

import static org.example.executor.ExecutorUtils.printState;
import static org.example.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.example.executor.RunnableTask;

public class FixedThreadPoolMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }
        es.close();
        log("== shutdown 완료 ==");
    }

}
