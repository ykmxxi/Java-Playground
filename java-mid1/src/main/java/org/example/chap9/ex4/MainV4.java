package org.example.chap9.ex4;

import java.util.Scanner;

import org.example.chap9.ex4.exception.SendExceptionV4;

public class MainV4 {

    public static void main(String[] args) {
        NetworkServiceV4 service = new NetworkServiceV4();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("전송할 문자: ");
            String input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }

            try {
                service.sendMessage(input);
            } catch (Exception e) { // 공통 예외 처리
                exceptionHandler(e);
            }
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료 합니다.");
    }

    /**
     * 공통 예외 처리
     */
    private static void exceptionHandler(final Exception e) {
        System.out.println("사용자 메시지: 알 수 없는 문제가 발생했습니다.");
        System.out.println("=== 개발자용 디버깅 메시지 ===");
        e.printStackTrace(System.out); // 스택 트레이스 출력
        // e.printStackTrace();

        // 필요하면 예외 별로 별도의 추가 처리 가능
        if (e instanceof SendExceptionV4 sendEx) {
            System.out.println("[전송 오류] 전송 데이터: " + sendEx.getSendData());
        }
    }

}
