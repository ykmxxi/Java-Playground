package org.example.cas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.util.MyLogger.log;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CasTest {

    private AtomicInteger atomicInteger;

    @BeforeEach
    void setUp() {
        atomicInteger = new AtomicInteger(0);
    }

    @Test
    @DisplayName("compareAndSet(expected, new): 현재 값이 expected와 같으면 new로 변경, true 반환")
    void compareAndSet() {
        assertThat(atomicInteger.get()).isEqualTo(0);

        assertThat(atomicInteger.compareAndSet(0, 1)).isTrue();
        assertThat(atomicInteger.get()).isEqualTo(1);

        assertThat(atomicInteger.compareAndSet(0, 1)).isFalse();
        assertThat(atomicInteger.get()).isEqualTo(1);
    }

    @Test
    @DisplayName("incrementAndGet(): 원자적 X 연산인 i++을 CAS 연산을 사용해 락 없이 구현")
    void incrementAndGetSuccess() {
        int result1 = MyAtomic.incrementAndGet(atomicInteger);
        assertThat(result1).isEqualTo(1);
        assertThat(atomicInteger.get()).isEqualTo(1);
        log("current value = " + atomicInteger.get());

        int result2 = MyAtomic.incrementAndGet(atomicInteger);
        assertThat(result2).isEqualTo(2);
        assertThat(atomicInteger.get()).isEqualTo(2);
        log("current value = " + atomicInteger.get());
    }

}
