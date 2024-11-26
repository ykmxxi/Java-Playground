package io.member;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int readChoice() {
        System.out.println("1.회원 등록 | 2.회원 목록 조회 | 3.종료");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // newLine 제거
        validateChoice(choice);
        return choice;
    }

    public String readId() {
        System.out.print("ID 입력: ");
        return scanner.nextLine();
    }

    public String readName() {
        System.out.print("Name 입력: ");
        return scanner.nextLine();
    }

    public int readAge() {
        System.out.print("Age 입력: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        return age;
    }

    private void validateChoice(final int choice) {
        if (choice < 1 || choice > 3) {
            throw new IllegalArgumentException();
        }
    }

}
