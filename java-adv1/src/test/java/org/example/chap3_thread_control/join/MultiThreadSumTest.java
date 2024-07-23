package org.example.chap3_thread_control.join;

import static java.lang.Thread.State.RUNNABLE;
import static java.lang.Thread.State.TERMINATED;
import static java.lang.Thread.State.TIMED_WAITING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MultiThreadSumTest {

    private SumTask task1 = new SumTask(1, 50);
    private SumTask task2 = new SumTask(51, 100);

    @Test
    @DisplayName("join(): 호출 스레드는 대상 스레드가 TERMINATED 상태가 될 때 까지 대기, WAITING")
    void join() throws InterruptedException {
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        // main 스레드는 WAITING 상태
        assertThat(thread1.getState()).isEqualTo(TERMINATED);
        assertThat(thread2.getState()).isEqualTo(TERMINATED);
        assertThat(Thread.currentThread().getState()).isEqualTo(RUNNABLE);
    }

    @Test
    @DisplayName("join(long millis): 호출 스레드는 대상 스레드가 TERMINATED 상태가 될 때 ms초 동안 대기, TIMED_WAITING")
    void joinMillis() throws InterruptedException {
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");
        thread1.start();
        thread2.start();

        thread1.join(500L);
        thread2.join(500L);
        // main 스레드는 TIMED_WAITING 상태

        // 0.5초 동안만 대기하기 때문에 작업이 완료되지 않음
        assertThat(thread1.getState()).isEqualTo(TIMED_WAITING);
        assertThat(thread2.getState()).isEqualTo(TIMED_WAITING);
        assertThat(Thread.currentThread().getState()).isEqualTo(RUNNABLE);
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result;

        public SumTask(final int startValue, final int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2_000L);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료");
        }

    }

}
