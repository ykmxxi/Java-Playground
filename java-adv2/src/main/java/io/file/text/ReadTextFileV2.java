package io.file.text;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ReadTextFileV2 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "가나다\nabc";
        Path path = Path.of(PATH);

        // 파일 쓰기
        Files.writeString(path, writeString, UTF_8);
        System.out.println("== writeString == ");
        System.out.println(writeString);

        // 파일 읽기
        List<String> allLines = Files.readAllLines(path, UTF_8);
        System.out.println("== read all lines == ");
        allLines.forEach(System.out::println);

        System.out.println("== lines == ");
        try (Stream<String> lines = Files.lines(path, UTF_8)) {
            lines.forEach(System.out::println);
        }
    }

}
