package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesPath {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");
        System.out.println("path = " + path);

        // 절대 경로(Absolute path)
        System.out.println("Absolute path = " + path.toAbsolutePath());
        // 정규 경로(Canonical path)
        System.out.println("Canonical path = " + path.toRealPath());

        Files.list(path)
                .forEach(FilesPath::printFileOrDirectory);
    }

    private static void printFileOrDirectory(final Path path) {
        if (Files.isRegularFile(path)) {
            System.out.println(String.join(" | ", "F", path.getFileName().toString()));
        }
        if (Files.isDirectory(path)) {
            System.out.println(String.join(" | ", "D", path.getFileName().toString()));
        }
    }

}
