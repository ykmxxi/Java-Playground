package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {

    private static final String PATH = "temp/hello.dat";

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(PATH)) {
            byte[] input = {65, 66, 67};
            fos.write(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream(PATH)) {
            byte[] buffer = new byte[10];
            int readCount = fis.read(buffer, 0, 10);
            System.out.println("readCount = " + readCount);
            System.out.println(Arrays.toString(buffer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
