package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FilesMain {

    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        // 파일, 디렉토리 존재 여부 확인
        System.out.println("Files.exists(file) = " + Files.exists(file));

        // 새 파일 생성
        try {
            Files.createFile(file);
            System.out.println("File created");
        } catch (FileAlreadyExistsException e) {
            System.out.println(file + " File already exists");
        }

        // 새 디렉토리 생성
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException e) {
            System.out.println(directory + " Directory already exists");
        }

        // 파일 삭제
//        Files.delete(file);
        // 일반 파일인지 확인
        System.out.println("Is regular file = " + Files.isRegularFile(file));
        // 디렉토리인지 확인
        System.out.println("Is directory = " + Files.isDirectory(directory));
        System.out.println("File name = " + file.getFileName());
        System.out.println("File size = " + Files.size(file) + "bytes");

        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File moved/renamed");

        System.out.println("Last modified = " + Files.getLastModifiedTime(newFile));

        BasicFileAttributes attributes = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("==== Attributes ====");
        System.out.println("Creation Time = " + attributes.creationTime());
        System.out.println("Is Directory = " + attributes.isDirectory());
        System.out.println("Is Regular File = " + attributes.isRegularFile());
        System.out.println("Is Symbolic Link = " + attributes.isSymbolicLink());
    }

}
