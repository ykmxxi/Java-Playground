package org.example.chap8.anonymous;

public class AnonymousEx1 {

    public void helloJava() {
        System.out.println("프로그램 시작"); // 변하지 않는 부분
        System.out.println("Hello Java"); // 변하는 부분
        System.out.println("프로그램 종료"); // 변하지 않는 부분
    }

    public void helloSpring() {
        System.out.println("프로그램 시작"); // 변하지 않는 부분
        System.out.println("Hello Spring"); // 변하는 부분
        System.out.println("프로그램 종료"); // 변하지 않는 부분
    }

    // 변하는 부분을 외부에서 전달 받아 사용한다
    public void hello(final String message) {
        System.out.println("프로그램 시작");
        System.out.println(message);
        System.out.println("프로그램 종료");
    }

}
