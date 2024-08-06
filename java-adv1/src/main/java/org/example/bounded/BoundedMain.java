package org.example.bounded;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.ArrayList;
import java.util.List;

public class BoundedMain {

    public static void main(String[] args) {
        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV5(2); // max = 2

        // 2. 생산자, 소비자 실행 순서 선택, 반드시 하나만 선택
        producerFirst(queue);
//        consumerFirst(queue);
    }

    private static void producerFirst(final BoundedQueue queue) {
        log("== [생산자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
        List<Thread> threads = new ArrayList<>();
        startProducer(queue, threads); // 생산자 3개 생성 후 순차적으로 실행
        printAllState(queue, threads); // 현재 상태 출력
        startConsumer(queue, threads); // 소비자 3개 생성 후 순차적으로 실행
        printAllState(queue, threads);
        log("== [생산자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
    }

    private static void consumerFirst(final BoundedQueue queue) {
        log("== [소비자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
        List<Thread> threads = new ArrayList<>();
        startConsumer(queue, threads); // 소비자 3개 생성 후 순차적으로 실행
        printAllState(queue, threads); // 현재 상태 출력
        startProducer(queue, threads); // 생산자 3개 생성 후 순차적으로 실행
        printAllState(queue, threads);
        log("== [소비자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
    }

    private static void startProducer(final BoundedQueue queue, final List<Thread> threads) {
        System.out.println();
        log("생산자 시작");
        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);
            threads.add(producer);
            producer.start();
            sleep(100L);
        }
    }

    private static void startConsumer(final BoundedQueue queue, final List<Thread> threads) {
        System.out.println();
        log("소비자 시작");
        for (int i = 1; i <= 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            sleep(100L);
        }
    }

    private static void printAllState(final BoundedQueue queue, final List<Thread> threads) {
        System.out.println();
        log("현재 상태 출력, 큐 데이터: " + queue);
        for (Thread thread : threads) {
            log(thread.getName() + ": " + thread.getState());
        }
    }

}
