package org.example.cas.atomic;

public class IncrementPerformanceMain {

    private static final long COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicInteger());       // 144ms
        test(new VolatileInteger());    // 669ms
        test(new SyncInteger());        // 1717ms
        test(new MyAtomicInteger());    // 686ms
    }

    private static void test(final IncrementInteger incrementInteger) {
        long start = System.currentTimeMillis();

        for (long i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long end = System.currentTimeMillis();
        System.out.println(incrementInteger.getClass().getSimpleName() + ": " + (end - start) + "ms");
    }

}
