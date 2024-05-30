package org.example.chap9.ex1;

public class NetworkClientV1 {

    private static final String SUCCESS = "success";
    private final String address;
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV1(final String address) {
        this.address = address;
    }

    public String connect() {
        if (connectError) {
            System.out.println(address + " 서버 연결 실패");
            return "connectError";
        }
        System.out.println(address + " 서버 연결 성공");
        return SUCCESS;
    }

    public String send(final String data) {
        if (sendError) {
            System.out.println(address + " 서버에 데이터 전송 실패: " + data);
            return "sendError";
        }
        System.out.println(address + " 서버에 데이터 전송: " + data);
        return SUCCESS;
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

}
