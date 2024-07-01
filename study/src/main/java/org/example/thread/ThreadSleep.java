package org.example.thread;

public class ThreadSleep {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        while (true) {
            try {
                System.out.println(System.currentTimeMillis() - start + "ms 지남");
                Thread.sleep(1000);

                if (overTwentySec(System.currentTimeMillis() - start)) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean overTwentySec(final long sec) {
        return sec > 20_000L;
    }

}
