package org.example.thread;

public class RunDaemonThreads {

    public static void main(String[] args) {
        ThreadSample thread1 = new ThreadSample();
        ThreadSample thread2 = new ThreadSample();
        ThreadSample daemonThread = new ThreadSample();

        System.out.println("thread1.getId() = " + thread1.getId());
        System.out.println("thread2.getId() = " + thread2.getId());

        System.out.println("thread1.getName() = " + thread1.getName());
        System.out.println("thread2.getName() = " + thread2.getName());

        System.out.println("thread1.getPriority() = " + thread1.getPriority());
        System.out.println("thread2.getPriority() = " + thread2.getPriority());

        daemonThread.setDaemon(true);
        System.out.println("thread1.isDaemon() = " + thread1.isDaemon());
        System.out.println("daemonThread.isDaemon() = " + daemonThread.isDaemon());

        System.out.println("데몬 쓰레드 시작");
        Thread daemon = new Thread(() -> {
            try {
                Thread.sleep(Long.MAX_VALUE); // 오랜 시간 대기를 걸어도 프로세스가 종료됨
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread = new Thread(() -> {
            try {
                System.out.println("작업 중");
                Thread.sleep(2000);
                System.out.println("작업 끝");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        daemon.setDaemon(true);
        thread.start();
        daemon.start();

        System.out.println("데몬 쓰레드 종료");
    }

}
