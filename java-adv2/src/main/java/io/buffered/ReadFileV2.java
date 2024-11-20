package io.buffered;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV2 {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            long start = System.currentTimeMillis();

            byte[] buffer = new byte[BUFFER_SIZE];
            int fileSize = 0;
            int size = 0;

            while ((size = fis.read(buffer)) != -1) {
                fileSize += size;
            }

            long end = System.currentTimeMillis();

            System.out.println("File name: " + FILE_NAME);
            System.out.println("File size: " + fileSize / 1024 / 1024 + "MB");
            System.out.println("Time taken: " + (end - start) + "ms"); // 4ms
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

}
