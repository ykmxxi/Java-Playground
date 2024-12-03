package network.tcp.v2;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerV2 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");

        try (
                // 서버 소켓은 TCP 연결만 지원하는 특별한 소켓
                ServerSocket serverSocket = new ServerSocket(PORT);
                // 실제 정보를 주고받는 것은 Socket
                Socket socket = serverSocket.accept() // blocking
        ) {
            log("서버 소켓 시작 - 리스닝 포트: " + PORT);
            log("서버 연결: " + socket);

            try (
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
                while (true) {
                    // 클라이언트로부터 문자 받기
                    String received = input.readUTF(); // blocking
                    log("client -> server: " + received);
                    if ("exit".equals(received)) {
                        break;
                    }

                    // 클라이언트에게 문자 보내기
                    String sendMessage = received + " World!";
                    output.writeUTF(sendMessage);
                    log("client <- server: " + sendMessage);

                }
                log("연결 종료");
            }
        }
    }

}
