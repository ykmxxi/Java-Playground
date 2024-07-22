package org.example.chap3_thread_control;

import static java.lang.Thread.State.NEW;
import static java.lang.Thread.State.RUNNABLE;
import static java.lang.Thread.State.TERMINATED;
import static java.lang.Thread.State.TIMED_WAITING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.util.MyLogger.log;

import org.junit.jupiter.api.Test;

class ThreadLifecycleTest {

    @Test
    void threadLifecycle() throws InterruptedException {
        Thread myThread = new Thread(new MyRunnable(), "myThread");
        log("thread state1 = " + myThread.getState());
        assertThat(myThread.getState()).isEqualTo(NEW);

        myThread.start();
        assertThat(myThread.getState()).isEqualTo(RUNNABLE);
        Thread.sleep(1_000L);
        log("thread state3 = " + myThread.getState());
        assertThat(myThread.getState()).isEqualTo(TIMED_WAITING);

        Thread.sleep(4_000L);
        log("thread state5 = " + myThread.getState());
        assertThat(myThread.getState()).isEqualTo(TERMINATED);
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                log("thread.start()");

                log("thread state2 = " + Thread.currentThread().getState());

                log("sleep(3_000L) start");
                Thread.sleep(3_000L);
                log("sleep(3_000L) end");

                log("thread state4 = " + Thread.currentThread().getState());

                log("thread.run() ended");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
