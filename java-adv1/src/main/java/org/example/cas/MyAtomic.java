package org.example.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomic {

    public static int incrementAndGet(final AtomicInteger atomicInteger) {
        int getValue;
        boolean result;

        do {
            getValue = atomicInteger.get();
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
        } while (!result);
        return getValue + 1;
    }

}
