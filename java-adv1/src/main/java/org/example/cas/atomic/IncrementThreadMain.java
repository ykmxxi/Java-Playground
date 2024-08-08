package org.example.cas.atomic;

import static org.example.util.ThreadUtils.sleep;

import java.util.ArrayList;
import java.util.List;

public class IncrementThreadMain {

    private static final int THREAD_COUNT = 1_000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger()); // 982
        test(new VolatileInteger()); // 993
        test(new SyncInteger()); // 1,000
    }

    private static void test(final IncrementInteger incrementInteger) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                sleep(10L);
                incrementInteger.increment();
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(incrementInteger.getClass().getSimpleName() + " result = " + incrementInteger.get());
    }

}
