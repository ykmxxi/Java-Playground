package io.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream("temp/print.txt");
                PrintStream printStream = new PrintStream(fos)
        ) {
            printStream.println("hello java!");
            printStream.println(10);
            printStream.println(true);
            printStream.printf("hello %s!", "world");
        }
    }

}
