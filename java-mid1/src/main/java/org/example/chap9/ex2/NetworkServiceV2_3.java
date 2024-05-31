package org.example.chap9.ex2;

/**
 * 정상 흐름: try 블럭, 예외 흐름: catch 블럭 -> 정상 흐름과 예외 흐름이 명확하게 분리됨
 * 남은 문제점
 * - disconnect()가 호출되지 않음
 */
public class NetworkServiceV2_3 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        try {
            // 정상 흐름
            client.connect();
            client.send(data);
            client.disconnect();
        } catch (NetworkClientExceptionV2 e) {
            // 예외 흐름
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }
    }

}
