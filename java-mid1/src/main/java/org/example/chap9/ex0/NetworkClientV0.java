package org.example.chap9.ex0;

public class NetworkClientV0 {

    private static final String SUCCESS = "success";
    private final String address;

    public NetworkClientV0(final String address) {
        this.address = address;
    }

    public String connect() {
        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
        return SUCCESS;
    }

    public String send(final String data) {
        System.out.println(address + " 서버에 데이터 전송: " + data);
        return SUCCESS;
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

}
