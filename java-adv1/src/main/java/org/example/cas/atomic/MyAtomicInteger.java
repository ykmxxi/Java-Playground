package org.example.cas.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger implements IncrementInteger {

    private final AtomicInteger value = new AtomicInteger(0);

    @Override
    public void increment() {
        value.incrementAndGet();
    }

    @Override
    public int get() {
        return value.get();
    }

}
