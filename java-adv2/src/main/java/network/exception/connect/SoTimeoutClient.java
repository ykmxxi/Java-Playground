package network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();

        long start = System.currentTimeMillis();
        try {
            socket.setSoTimeout(3000); // 타임아웃 시간 설정
            int read = input.read(); // 기본 타임아웃 시간은 무한
            System.out.println("read = " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("시간: " + (end - start) + "ms");
        socket.close();
    }

}
