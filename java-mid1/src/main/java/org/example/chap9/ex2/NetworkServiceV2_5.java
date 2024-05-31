package org.example.chap9.ex2;

/**
 * 정상 흐름: try 블럭, 예외 흐름: catch 블럭 -> 정상 흐름과 예외 흐름이 명확하게 분리됨
 * 리소스 반환 문제: finally 블럭에서 처리
 * finally 블럭은 무조건 실행됨(정상 흐름, 예외 catch, 예외 던짐)
 * 예외를 밖으로 던지는 경우(catch 구문에서 잡지 못하는 예외)도 finally 블럭이 실행된 뒤 던짐
 */
public class NetworkServiceV2_5 {

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
        } finally {
            client.disconnect();
        }
    }

}
