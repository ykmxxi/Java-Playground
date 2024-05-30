package org.example.chap9.ex1;

/**
 * 외부 자원(네트워크 연결)은 반드시 연결 해제해야 한다
 * Error가 발생해도 disconnect()를 반드시 호출해서 연결을 해제
 *
 * 예외 처리를 사용하지 않고 반환 값을 이용해 정상 흐름과 예외 흐름을 파악하기 어렵다 -> 예외 처리 메커니즘 필요
 */
public class NetworkServiceV1_3 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
        } else {
            String sendResult = client.send(data);
            if (isError(sendResult)) {
                System.out.println("[전송 오류 발생] 오류 코드: " + sendResult);
            }
        }
        client.disconnect();
    }

    private boolean isError(final String result) {
        return !"success".equals(result);
    }

}
