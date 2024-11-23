package io.text;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReaderWriterMainV2 {

    public static void main(String[] args) throws IOException {
        String write = "ABC";
        System.out.println("write = " + write);

        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8)
        ) {
            osw.write(write);
        }

        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis, UTF_8)
        ) {
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = isr.read()) != -1) { // read()가 int 반환 -> char 캐스팅 필요
                content.append((char) ch);
            }
            System.out.println("content = " + content);
        }
    }

}
