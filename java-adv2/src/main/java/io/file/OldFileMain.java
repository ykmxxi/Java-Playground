package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        // 현재 파일 존재 여부
        System.out.println("file.exists() = " + file.exists()); // false

        // 파일 생성
        boolean created = file.createNewFile();
        System.out.println("File created = " + created); // true

        // 디렉토리 생성
        boolean createdDir = directory.mkdir();
        System.out.println("Directory created = " + createdDir); // true

        // 파일 삭제
//        boolean deleted = file.delete();
//        System.out.println("File deleted = " + deleted);

        // 파일인지 디렉토리인지 확인
        System.out.println("Is File = " + file.isFile());
        System.out.println("Is Directory = " + directory.isDirectory());
        // 정보: 파일 이름, 크기
        System.out.println("File name = " + file.getName());
        System.out.println("File size = " + file.length() + "bytes");

        // 파일 이름 변경
        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("File renamed = " + renamed);

        // 마지막으로 수정된 시간
        long lastModified = newFile.lastModified();
        System.out.println("Last modified = " + new Date(lastModified));
    }

}
