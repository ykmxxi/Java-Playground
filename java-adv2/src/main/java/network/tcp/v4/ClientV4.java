package network.tcp.v4;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientV4 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            log("소켓 연결: " + socket); // 클라이언트의 포트는 남아있는 포트 중 랜덤 할당

            Scanner scanner = new Scanner(System.in);
            while (true) {
                // server 문자 보내기
                System.out.print("전송 문자 : ");
                String sendMessage = scanner.nextLine();

                output.writeUTF(sendMessage);
                log("client -> server: " + sendMessage);
                if ("exit".equals(sendMessage)) {
                    break;
                }

                // server 문자 받기
                String receivedMessage = input.readUTF();
                log("client <- server: " + receivedMessage);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            closeAll(socket, input, output);
            log("연결 종료: " + socket);
        }
    }

}
