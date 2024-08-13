package org.example.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import org.junit.jupiter.api.Test;

class ConcurrentCollectionTest {

    @Test
    void synchronizedCollection() throws InterruptedException {
        long syncTime = getTime(Collections.synchronizedList(new ArrayList<>()));
        System.out.println("syncTime = " + syncTime);
    }

    @Test
    void concurrentCollection() throws InterruptedException {
        long concurrentTime = getTime(new CopyOnWriteArrayList<>());
        System.out.println("concurrentTime = " + concurrentTime);
    }

    @Test
    void concurrentList() throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread thread1 = new Thread(() -> list.add(1));
        Thread thread2 = new Thread(() -> list.add(2));
        Thread thread3 = new Thread(() -> list.add(3));
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    void concurrentSet() throws InterruptedException {
        // 입력 순서 보장 X
        Set<Integer> set = new CopyOnWriteArraySet<>();
        Thread thread1 = new Thread(() -> set.add(1));
        Thread thread2 = new Thread(() -> set.add(2));
        Thread thread3 = new Thread(() -> set.add(3));
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        assertThat(set).contains(1, 2, 3);

        Set<Integer> sortedSet = new ConcurrentSkipListSet<>();
        Thread thread4 = new Thread(() -> sortedSet.add(3));
        Thread thread5 = new Thread(() -> sortedSet.add(1));
        Thread thread6 = new Thread(() -> sortedSet.add(2));
        thread4.start();
        thread5.start();
        thread6.start();
        thread4.join();
        thread5.join();
        thread6.join();

        assertThat(sortedSet).containsExactly(1, 2, 3);
    }

    @Test
    void concurrentMap() throws InterruptedException {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        Thread thread1 = new Thread(() -> map.put(1, "a"));
        Thread thread2 = new Thread(() -> map.put(2, "b"));
        Thread thread3 = new Thread(() -> map.put(3, "c"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        assertThat(map.keySet()).contains(1, 2, 3);
        assertThat(map.values()).contains("a", "b", "c");

        Map<Integer, String> sortedMap = new ConcurrentSkipListMap<>();
        Thread thread4 = new Thread(() -> sortedMap.put(3, "c"));
        Thread thread5 = new Thread(() -> sortedMap.put(1, "a"));
        Thread thread6 = new Thread(() -> sortedMap.put(2, "b"));
        thread4.start();
        thread5.start();
        thread6.start();
        thread4.join();
        thread5.join();
        thread6.join();

        assertThat(sortedMap.keySet()).containsExactly(1, 2, 3);
    }

    private long getTime(final List<Integer> list) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            Thread thread = new Thread(() -> list.add(new Random().nextInt(100)));
            thread.start();
            thread.join();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

}
