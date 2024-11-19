package io.start;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;

        byte[] bytes = ("Hello!" + System.lineSeparator()).getBytes(UTF_8);
        printStream.write(bytes); // write 하고 출력해줌, print 처럼 개행 문자 추가 없이 출력
        printStream.println("Print!"); // 내부적으로 writeln() 사용, 즉 개행 문자를 추가해 write
    }

}
