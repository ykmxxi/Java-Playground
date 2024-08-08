package org.example.cas.atomic;

public class VolatileInteger implements IncrementInteger {

    private volatile int value;

    @Override
    public void increment() {
        value++; // 인스턴스 필드(공유 자원) 증가
    }

    @Override
    public int get() {
        return value;
    }

}
