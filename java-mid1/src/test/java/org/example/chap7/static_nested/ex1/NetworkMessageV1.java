package org.example.chap7.static_nested.ex1;

// 리팩토링 전
public class NetworkMessageV1 {

    private final String content;

    public NetworkMessageV1(final String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }

}
