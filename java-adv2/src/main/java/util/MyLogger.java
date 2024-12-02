package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(final Object obj) {
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s" + System.lineSeparator(),
                time, Thread.currentThread().getName(), obj);
    }

}