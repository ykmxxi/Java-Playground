package org.example.chap7.static_nested.ex1;

// 리팩토링 후: NetworkMessage를 정적 내부 클래스로 변환
public class NetworkV2 {

    public void sendMessage(final String text) {
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }

    private static class NetworkMessage {

        private final String content;

        NetworkMessage(final String content) {
            this.content = content;
        }

        public void print() {
            System.out.println(content);
        }

    }

}
