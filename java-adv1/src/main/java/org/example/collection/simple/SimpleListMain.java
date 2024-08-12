package org.example.collection.simple;

import static org.example.util.MyLogger.log;

import org.example.collection.simple.list.BasicList;
import org.example.collection.simple.list.SimpleList;
import org.example.collection.simple.list.SyncProxyList;

public class SimpleListMain {

    public static void main(String[] args) throws InterruptedException {
        //test(new BasicList());
        //test(new SyncList());
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(final SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        Runnable taskA = () -> {
            list.add("A");
            log("Thread-1: list.add(A)");
        };
        Runnable taskB = () -> {
            list.add("B");
            log("Thread-2: list.add(B)");
        };

        Thread thread1 = new Thread(taskA, "Thread-1");
        Thread thread2 = new Thread(taskB, "Thread-2");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        log(list);
    }

}
