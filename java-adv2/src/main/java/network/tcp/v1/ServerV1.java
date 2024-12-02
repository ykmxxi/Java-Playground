package network.tcp.v1;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");

        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept()
        ) {
            log("서버 소켓 시작 - 리스닝 포트: " + PORT);
            log("서버 연결: " + socket);

            try (
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
                // 클라이언트로부터 문자 받기
                String received = input.readUTF();
                log("client -> server: " + received);

                // 클라이언트에게 문자 보내기
                String sendMessage = received + " World!";
                output.writeUTF(sendMessage);
                log("client <- server: " + sendMessage);

                log("연결 종료");
            }
        }
    }

}
