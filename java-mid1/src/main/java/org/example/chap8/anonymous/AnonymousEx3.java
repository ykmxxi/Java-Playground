package org.example.chap8.anonymous;

import java.util.Random;

public class AnonymousEx3 {

    public static void hello(final Process process) {
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        class Dice implements Process {

            @Override
            public void run() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + randomValue);
            }

        }

        class Sum implements Process {

            @Override
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("i = " + i);
                }
            }

        }

        Process dice = new Dice();
        Process sum = new Sum();

        hello(dice);
        hello(sum);
    }

}
