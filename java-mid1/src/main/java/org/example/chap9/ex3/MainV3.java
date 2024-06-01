package org.example.chap9.ex3;

import java.util.Scanner;

import org.example.chap9.ex3.exception.NetworkClientExceptionV3;

public class MainV3 {

    public static void main(String[] args) throws NetworkClientExceptionV3 {
        NetworkServiceV3_2 service = new NetworkServiceV3_2();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("전송할 문자: ");
            String input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }
            service.sendMessage(input);
            System.out.println();
        }

        System.out.println("프로그램을 정상 종료 합니다.");
    }

}
