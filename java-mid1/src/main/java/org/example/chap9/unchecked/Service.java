package org.example.chap9.unchecked;

public class Service {

    Client client = new Client();

    public void callCatch() {
        try {
            client.call();
        } catch (MyUncheckedException e) {
            System.out.println("예외 처리, message = " + e.getMessage());
        }
        System.out.println("정상 로직");
    }

    /**
     * "throws 예외" 생략 가능, 명시해도 상관 없음
     */
    public void callThrow() {
        client.call();
    }

}
