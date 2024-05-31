package org.example.chap9.ex2;

/**
 * 남은 문제점
 * - 정상 흐름과 예외 흐름이 섞여 있어 코드가 복잡
 * - 연결을 해제하지 못하고 있음(disconnect() 호출 X)
 */
public class NetworkServiceV2_2 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        try {
            client.connect();
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
            return;
        }
        try {
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
            return;
        }

        client.disconnect();
    }

}
