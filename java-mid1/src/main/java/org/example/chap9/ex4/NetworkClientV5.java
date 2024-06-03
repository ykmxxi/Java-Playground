package org.example.chap9.ex4;

import org.example.chap9.ex4.exception.ConnectExceptionV4;
import org.example.chap9.ex4.exception.SendExceptionV4;

public class NetworkClientV5 implements AutoCloseable {

    private final String address;
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV5(final String address) {
        this.address = address;
    }

    public void connect() throws ConnectExceptionV4 {
        if (connectError) {
            throw new ConnectExceptionV4(address + " 서버 연결 실패", address);
        }
        System.out.println(address + " 서버 연결 성공");
    }

    public void send(final String data) throws SendExceptionV4 {
        if (sendError) {
            throw new SendExceptionV4(address + " 서버에 데이터 전송 실패", data);
        }
        System.out.println(address + " 서버에 데이터 전송: " + data);
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(final String data) {
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }

    @Override
    public void close() { // 별도의 예외가 발생하지 않아 throws Exception 제거
        System.out.println("NetworkClientV5.close");
        disconnect();
    }

}
