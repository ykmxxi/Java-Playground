package org.example.unit_test.chap06.v1;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class IFileSystem {

    public List<String> getFiles(final String directoryName) {
        Path directory = Path.of(directoryName);
        try (Stream<Path> paths = Files.list(directory)) {
            return paths.sorted()
                    .map(path -> path.getFileName().toString())
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path createNewFile(final String directoryName, final String fileName) {
        Path newFile = Path.of(directoryName + fileName);
        try {
            return Files.createFile(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(final Path file, final String newRecord) {
        try {
            Files.writeString(file, newRecord, UTF_8, APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path getLast(final String directoryName) {
        Path directory = Path.of(directoryName);
        try (Stream<Path> paths = Files.list(directory)) {
            return paths.sorted()
                    .toList()
                    .getLast();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
