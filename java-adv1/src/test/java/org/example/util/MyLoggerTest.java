package org.example.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.util.MyLogger.log;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MyLoggerTest {

    @Test
    void logTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        log("hello thread");
        assertThat(out.toString().substring(0, 12)).matches("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}");
        assertThat(out.toString()).contains("main");
        assertThat(out.toString()).contains("hello thread");

        log(123);
        assertThat(out.toString().substring(0, 12)).matches("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}");
        assertThat(out.toString()).contains("main");
        assertThat(out.toString()).contains("123");
    }

}
