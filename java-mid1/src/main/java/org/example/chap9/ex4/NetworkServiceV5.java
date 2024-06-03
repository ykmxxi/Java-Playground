package org.example.chap9.ex4;

public class NetworkServiceV5 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";

        try (NetworkClientV5 client = new NetworkClientV5(address)) {
            client.initError(data);
            client.connect();
            client.send(data);

            // try 블럭이 끝나면 바로 자동으로 close() 호출
        } catch (Exception e) {
            System.out.println("[예외 확인] 메시지: " + e.getMessage());
            throw e;
        }
    }

}
