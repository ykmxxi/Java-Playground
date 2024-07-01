package org.example.thread;

public class NameThread extends Thread {

    private int num;

    public NameThread(final int num) {
        super("MyThread");
        this.num = num;
    }

    public NameThread(final String name, final int num) {
        super(name);
        this.num = num;
    }

    @Override
    public void run() {
        num++;
        System.out.println("This is NameThread's run() method.");
        System.out.println("num = " + num);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            NameThread nameThread = new NameThread("Thread-" + i, 100);
            nameThread.start();
        }
    }

}
