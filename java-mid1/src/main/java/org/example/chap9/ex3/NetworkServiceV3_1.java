package org.example.chap9.ex3;

import org.example.chap9.ex3.exception.ConnectExceptionV3;
import org.example.chap9.ex3.exception.SendExceptionV3;

public class NetworkServiceV3_1 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (SendExceptionV3 e) {
            System.out.println("[전송 오류] 데이터: " + e.getSendData() + ", 메시지: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }

}
