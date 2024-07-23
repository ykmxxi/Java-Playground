package org.example.util;

import static org.example.util.MyLogger.log;

public class ThreadUtils {

    public static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("InterruptedException 발생: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
