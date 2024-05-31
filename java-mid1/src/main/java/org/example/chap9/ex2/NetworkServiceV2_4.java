package org.example.chap9.ex2;

/**
 * 정상 흐름: try 블럭, 예외 흐름: catch 블럭 -> 정상 흐름과 예외 흐름이 명확하게 분리됨
 * 리소스 반환 문제: catch에서 잡을 수 없는 예외가 발생하면 리소스 반환이 이루어지지 않음
 */
public class NetworkServiceV2_4 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        try {
            // 정상 흐름
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            // 예외 흐름
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }

        // NetworkClientException이 아닌 다른 예외가 발생해서 예외가 밖으로 던져지면 무시
        client.disconnect();
    }

}
