package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

    private static final String PATH = "temp/hello.dat";

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(PATH)) {
            fos.write(65);
            fos.write(66);
            fos.write(67);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream(PATH)) {
            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
