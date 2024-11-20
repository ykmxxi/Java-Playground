package io.buffered;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV2 {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            long start = System.currentTimeMillis();

            byte[] buffer = new byte[BUFFER_SIZE];
            int bufferIndex = 0;

            for (int i = 0; i < FILE_SIZE; i++) {
                buffer[bufferIndex++] = 1;

                if (bufferIndex == BUFFER_SIZE) {
                    fos.write(buffer);
                    bufferIndex = 0;
                }
            }
            // 끝 부분에 오면 버퍼가 가득차지 않고 남아있을 수 있다. 버퍼에 남은 부분 쓰기
            if (bufferIndex > 0) {
                fos.write(buffer, 0, bufferIndex);
            }

            long end = System.currentTimeMillis();

            System.out.println("File created: " + FILE_NAME);
            System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
            System.out.println("Time taken: " + (end - start) + "ms"); // 32ms
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
