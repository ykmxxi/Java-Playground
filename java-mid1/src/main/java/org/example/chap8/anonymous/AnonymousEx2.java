package org.example.chap8.anonymous;

import java.util.Random;

public class AnonymousEx2 {

    public static void helloDice() {
        System.out.println("프로그램 시작");

        // 코드 조각 시작
        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위 = " + randomValue);
        // 코드 조각 종료

        System.out.println("프로그램 종료");
    }

    public static void helloSum() {
        System.out.println("프로그램 시작");

        // 코드 조각 시작
        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }
        // 코드 조각 종료

        System.out.println("프로그램 종료");
    }

    // 한 메서드에서 실행되도록 리팩토링
    public static void hello(final Process process) {
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");
    }

    static class Dice implements Process {

        @Override
        public void run() {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        }

    }

    static class Sum implements Process {

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        }

    }

    public static void main(String[] args) {
        Process dice = new Dice();
        Process sum = new Sum();

        hello(dice);
        hello(sum);
    }

}
