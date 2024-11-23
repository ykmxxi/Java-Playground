package io.text;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterMainV3 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        try (FileWriter fw = new FileWriter(FILE_NAME, UTF_8)) {
            System.out.println("write string = " + writeString);
            fw.write(writeString);
        }

        try (FileReader fr = new FileReader(FILE_NAME, UTF_8)) {
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = fr.read()) != -1) {
                content.append((char) ch);
            }
            System.out.println("read = " + content);
        }
    }

}
