package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2 {

    private static final String PATH = "temp/hello.dat";

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(PATH)) {
            fos.write(65);
            fos.write(66);
            fos.write(67);
//            byte[] bytes = "ABC".getBytes();
//            fos.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream(PATH)) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.println(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
