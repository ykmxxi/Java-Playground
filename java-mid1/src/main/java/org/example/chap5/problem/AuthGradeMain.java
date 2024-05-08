package org.example.chap5.problem;

import java.util.Scanner;

public class AuthGradeMain {

    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println("등급을 다시 입력해 주세요.");
            run();
        }
    }

    private static void run() {
        String input = getInput();
        int level = findLevel(input);
        printMenuCategories(level);
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        return scanner.nextLine();
    }

    private static int findLevel(final String input) {
        return AuthGrade.matchLevel(input);
    }

    private static void printMenuCategories(final int level) {
        System.out.println("==메뉴 목록==");
        if (level > 0) {
            System.out.println("- 메인 화면");
        }
        if (level > 1) {
            System.out.println("- 이메일 관리 화면");
        }
        if (level > 2) {
            System.out.println("- 관리자 화면");
        }
    }

}
