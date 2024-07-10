package org.example.chap9.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskScheduler {

    private final Queue<Task> tasks = new ArrayDeque<>();

    public void addTask(final Task task) {
        tasks.offer(task);
    }

    public int getRemainingTasks() {
        return tasks.size();
    }

    public void processNextTask() {
        Task task = tasks.poll();
        if (task != null) {
            task.execute();
        }
    }

}
