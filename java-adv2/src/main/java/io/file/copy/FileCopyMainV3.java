package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyMainV3 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String copyName = "temp/copy.dat";
        String newName = "temp/copy_new.dat";

        Path source = Path.of(copyName);
        Path target = Path.of(newName);

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }

}
