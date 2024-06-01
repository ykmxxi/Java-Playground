package org.example.chap9.ex3;

import org.example.chap9.ex3.exception.ConnectExceptionV3;
import org.example.chap9.ex3.exception.NetworkClientExceptionV3;

public class NetworkServiceV3_2 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try {
            client.connect();
            if (data.contains("runtime")) {
                throw new RuntimeException("알 수 없는 오류");
            }
            client.send(data);
        } catch (ConnectExceptionV3 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (NetworkClientExceptionV3 e) {
            System.out.println("[네트워크 오류] 메시지: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[알 수 없는 오류] 메시지: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }

}
