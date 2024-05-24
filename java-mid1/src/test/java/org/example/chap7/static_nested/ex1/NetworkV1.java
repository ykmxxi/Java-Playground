package org.example.chap7.static_nested.ex1;

// 리팩토링 전
public class NetworkV1 {

    public void sendMessage(final String text) {
        NetworkMessageV1 networkMessage = new NetworkMessageV1(text);
        networkMessage.print();
    }

}
