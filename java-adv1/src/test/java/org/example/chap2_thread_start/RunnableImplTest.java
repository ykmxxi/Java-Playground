package org.example.chap2_thread_start;

import static org.example.util.MyLogger.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RunnableImplTest {

    @Test
    @DisplayName("중첩 클래스 사용")
    void nestedClass() {
        log("main() start");
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        log("main() end");
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run()");
        }

    }

    @Test
    @DisplayName("익명 클래스 사용")
    void anonymousClass() {
        log("main() start");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        // 따로 변수로 선언하지 않고 바로 전달해도 됨
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });
        thread2.start();

        log("main() end");
    }

    @Test
    @DisplayName("람다 사용: 메서드(함수) 코드 조각을 전달")
    void lambda() {
        Thread thread = new Thread(() -> log("run()"));
        thread.start();
    }

}
