package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {

    private static final String PATH = "temp/hello.dat";

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(PATH)) {
            byte[] input = {65, 66, 67};
            fos.write(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream(PATH)) {
            byte[] readBytes = fis.readAllBytes();
            System.out.println(Arrays.toString(readBytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
