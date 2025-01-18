package network.exception.connect;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMain2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        try {
            Socket socket = new Socket();
            // 소켓 연결 타임아웃 1초 설정
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 1000);
        } catch (SocketTimeoutException e) {
            // java.net.SocketTimeoutException: Connect timed out
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("시간: " + (end - start) + "ms");
    }

}
