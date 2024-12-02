package network.tcp.v1;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        try (
                Socket socket = new Socket("localhost", PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            log("소켓 연결: " + socket);

            // server 문자 보내기
            String sendMessage = "Hello";
            output.writeUTF(sendMessage);
            log("client -> server: " + sendMessage);

            // server 문자 받기
            String receivedMessage = input.readUTF();
            log("client <- server: " + receivedMessage);
        }
    }

}
