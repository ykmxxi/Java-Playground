package io.buffered;

import static io.buffered.BufferedConst.FILE_NAME;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV1 {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            long start = System.currentTimeMillis();

            int fileSize = 0;
            int data;
            while ((data = fis.read()) != -1) {
                fileSize++;
            }

            long end = System.currentTimeMillis();

            System.out.println("File name: " + FILE_NAME);
            System.out.println("File size: " + fileSize / 1024 / 1024 + "MB");
            System.out.println("Time taken: " + (end - start) + "ms"); // 9.9초
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

}
