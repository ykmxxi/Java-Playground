package org.example.bounded;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Clock;
import java.time.LocalTime;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlockingQueueTest {

    private BlockingQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new ArrayBlockingQueue<>(2);
        queue.add(1);
        queue.add(2);
    }

    @Test
    @DisplayName("ThrowsException: 예외를 던지고, 예외를 받아서 처리")
    void throwsException() {
        assertThatThrownBy(() -> queue.add(3))
                .isInstanceOf(IllegalStateException.class);

        queue.clear();
        assertThatThrownBy(() -> queue.remove())
                .isInstanceOf(NoSuchElementException.class);

        assertThatThrownBy(() -> queue.element())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Special Value: 대기 X, 즉시 false 반환")
    void specialValue() {
        assertThat(queue.offer(3)).isFalse();

        queue.clear();
        assertThat(queue.poll()).isNull();

        assertThat(queue.peek()).isNull();
    }

    @Test
    @DisplayName("Times Out: 지정된 시간 동안 대기")
    void timesOut() {
        Clock clock = Clock.systemDefaultZone();
        LocalTime start = LocalTime.now(clock);
        try {
            queue.offer(3, 1_000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertThat(LocalTime.now(clock)).isAfterOrEqualTo(start.plusSeconds(1L));
    }

}
