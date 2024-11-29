package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class OldFilePath {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/.."); // ..은 상위, 여기서는 temp 상위 java-adv2
        System.out.println("path = " + file.getPath());

        // 절대 경로(Absolute path)
        System.out.println("Absolute path = " + file.getAbsolutePath());
        // 정규 경로(Canonical path)
        System.out.println("Canonical path = " + file.getCanonicalPath());

        Arrays.stream(file.listFiles()) // java-adv2 하위 모든 파일과 디렉토리
                .forEach(OldFilePath::printFileOrDirectory);
    }

    private static void printFileOrDirectory(final File file) {
        if (file.isFile()) {
            System.out.println(String.join(" | ", "F", file.getName()));
        }
        if (file.isDirectory()) {
            System.out.println(String.join(" | ", "D", file.getName()));
        }
    }

}
