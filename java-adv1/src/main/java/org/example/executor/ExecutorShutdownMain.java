package org.example.executor;

import static org.example.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdownMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("longTask", 100_000L)); // 100초 대기

        ExecutorUtils.printState(es);
        log("== shutdown 시작 ==");
        shutdownAndAwaitTermination(es);
        log("== shutdown 완료 ==");
        ExecutorUtils.printState(es);
    }

    private static void shutdownAndAwaitTermination(final ExecutorService es) {
        // non-blocking, 새로운 작업 받지 않음. 처리 중이거나 대기중인 작업을 처리하고 스레드 풀의 자원을 정리
        es.shutdown();

        try {
            // 대기중인 작업들을 모두 완료할 때 까지 10초 대기
            if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                log("서비스 정상 종료 실패 -> 강제 종료 시도");
                es.shutdownNow(); // 강제 종료 시도
                // 작업이 취소될 때 까지 대기
                if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                    log("서비스가 종료되지 않았습니다.");
                }
            }
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
