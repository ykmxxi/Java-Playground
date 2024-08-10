package org.example.cas.spin_lock;

import static org.example.util.MyLogger.log;

public class SpinLockMain {

    public static void main(String[] args) {
        // SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable runnable = () -> {
            spinLock.lock();
            // critical section
            try {
                log("비즈니스 로직 실행");
            } finally {
                spinLock.unlock();
            }
        };

        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");
        thread1.start();
        thread2.start();
    }

}
