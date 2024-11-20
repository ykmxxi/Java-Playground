package io.buffered;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV1 {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < FILE_SIZE; i++) {
                fos.write(1);
            }
            long end = System.currentTimeMillis();

            System.out.println("File created: " + FILE_NAME);
            System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
            System.out.println("Time taken: " + (end - start) + "ms"); // 79초
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
