package org.example.executor.future;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.example.executor.CallableTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutorServiceInvokeTest {

    private ExecutorService es;
    private List<CallableTask> tasks;

    @BeforeEach
    void setUp() {
        es = Executors.newFixedThreadPool(10);
        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 2000);
        CallableTask task3 = new CallableTask("task3", 3000);
        tasks = List.of(task1, task2, task3);
    }

    @Test
    @DisplayName("모든 Callable 작업을 제출하고, 모든 작업이 완료될 때까지 기다린다")
    void invokeAll() throws InterruptedException {
        List<Future<Integer>> futures = es.invokeAll(tasks);

        assertThat(futures.stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }).toList()
        ).contains(1000, 2000, 3000);
    }

    @Test
    @DisplayName("하나의 Callable 작업이 완료될 때까지 기다리고, 가장 먼저 완료된 작업의 결과를 반환")
    void invokeAny() throws ExecutionException, InterruptedException {
        Integer result = es.invokeAny(tasks);

        assertThat(result).isEqualTo(1000);
    }

}
