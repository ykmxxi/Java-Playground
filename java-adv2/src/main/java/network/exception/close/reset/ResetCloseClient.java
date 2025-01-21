package network.exception.close.reset;

import static util.MyLogger.log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ResetCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        // client <- server: FIN
        Thread.sleep(1000L); // server가 close() 호출할 때 까지 잠시 대기

        // client -> server: PUSH[1], 데이터 전송
        output.write(1);

        // TCP 규약 벗어남, 서버가 FIN을 전송했는데 ACK + FIN을 전송하지 않으면 RST 전송
        // client <- server: RST
        Thread.sleep(1000L); // RST 패킷 전송 대기

        try {
            // java.net.SocketException: Connection reset
            int read = input.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            // java.net.SocketException: Broken pipe
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}
