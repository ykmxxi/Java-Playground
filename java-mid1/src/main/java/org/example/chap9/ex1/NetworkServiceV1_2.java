package org.example.chap9.ex1;

public class NetworkServiceV1_2 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
            return;
        }
        String sendResult = client.send(data);
        if (isError(sendResult)) {
            System.out.println("[전송 오류 발생] 오류 코드: " + sendResult);
            return;
        }
        client.disconnect();
    }

    private boolean isError(final String result) {
        return !"success".equals(result);
    }

}
