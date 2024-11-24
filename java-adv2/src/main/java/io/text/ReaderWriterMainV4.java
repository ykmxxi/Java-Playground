package io.text;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        try (
                FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
                BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE)
        ) {
            System.out.println("=== WRITE ===");
            System.out.println(writeString);
            bw.write(writeString);
        }

        try (
                FileReader fr = new FileReader(FILE_NAME, UTF_8);
                BufferedReader br = new BufferedReader(fr, BUFFER_SIZE)
        ) {
            StringBuilder content = new StringBuilder();
            String readLine;
            while ((readLine = br.readLine()) != null) {
                content.append(readLine).append(System.lineSeparator());
            }
            System.out.println("=== READ ===");
            System.out.println(content);
        }
    }

}
