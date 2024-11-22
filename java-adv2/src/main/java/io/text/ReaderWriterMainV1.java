package io.text;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {
        String write = "ABC";
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            byte[] writeBytes = write.getBytes(UTF_8); // encoding
            System.out.println("write = " + write);
            System.out.println("write bytes = " + Arrays.toString(writeBytes));

            fos.write(writeBytes);
        }

        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            byte[] readBytes = fis.readAllBytes();
            String read = new String(readBytes, UTF_8); // decoding
            System.out.println("read = " + read);
            System.out.println("read bytes = " + Arrays.toString(readBytes));
        }
    }

}
