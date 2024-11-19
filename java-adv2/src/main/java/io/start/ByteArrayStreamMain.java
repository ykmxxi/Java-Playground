package io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {

    public static void main(String[] args) {
        byte[] input = {1, 2, 3};

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            // 메모리에 쓰기
            bos.write(input);

            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray())) {
                // 메모리에서 읽기
                byte[] readBytes = bis.readAllBytes();
                System.out.println(Arrays.toString(readBytes));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
