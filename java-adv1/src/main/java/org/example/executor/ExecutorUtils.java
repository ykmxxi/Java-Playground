package org.example.executor;

import static org.example.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

    private ExecutorUtils() {} // 유틸 클래스는 상속도 막아 객체 생성의 여지를 주지 않는다

    public static void printState(final ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize(); // 스레드 풀에서 관리되는 스레드의 숫자
            int active = poolExecutor.getActiveCount(); // 작업을 수행하는 스레드의 숫자
            int queuedTasks = poolExecutor.getQueue().size(); // 큐에 대기중인 작업의 숫자
            long completedTasks = poolExecutor.getCompletedTaskCount(); // 완료된 작업의 숫자
            log("[pool=" + pool + ", active=" + active + ", queuedTasks=" +
                    queuedTasks + ", completedTasks=" + completedTasks + "]");
            return;
        }
        log(executorService);
    }

    public static void printState(final ExecutorService executorService, final String taskName) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTasks = poolExecutor.getQueue().size();
            long completedTasks = poolExecutor.getCompletedTaskCount();
            log(taskName + " -> [pool=" + pool + ", active=" + active + ", queuedTasks=" +
                    queuedTasks + ", completedTasks=" + completedTasks + "]");
            return;
        }
        log(taskName + " -> " + executorService);
    }

}
