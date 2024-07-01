package org.example.thread;

class RunnableSample implements Runnable {

    @Override
    public void run() {
        System.out.println("This is RunnableSample's run() method.");
    }

}

class ThreadSample extends Thread {

    @Override
    public void run() {
        System.out.println("This is ThreadSample's run() method.");
    }

}

public class RunThreads {

    public static void main(String[] args) {
        RunThreads runThreads = new RunThreads();
        runThreads.runBasic();

        // MultiThread
        RunnableSample[] runnableSamples = new RunnableSample[5];
        ThreadSample[] threadSamples = new ThreadSample[5];
        for (int i = 0; i < 5; i++) {
            runnableSamples[i] = new RunnableSample();
            threadSamples[i] = new ThreadSample();

            new Thread(runnableSamples[i]).start();
            threadSamples[i].start();
        }
        System.out.println("Multi Thread ended");
    }

    public void runBasic() {
        RunnableSample runnable = new RunnableSample();
        new Thread(runnable).start();

        ThreadSample thread = new ThreadSample();
        thread.start();

        System.out.println("RunThreads.runBasic ended");
    }

}
