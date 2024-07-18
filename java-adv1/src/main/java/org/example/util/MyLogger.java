package org.example.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 실행하면 현재 시간, 스레드 이름, 출력 내용등이 로그로 출력
 */
public abstract class MyLogger {

    // 시:분:초.ms
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(final Object obj) {
        String time = LocalTime.now().format(formatter);
        // [     main]: 앞에 5칸 공백, [ Thread-0]: 앞에 1칸 공백
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }

}
