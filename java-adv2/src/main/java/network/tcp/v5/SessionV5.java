package network.tcp.v5;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SessionV5 implements Runnable {

    private final Socket socket;

    public SessionV5(final Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            while (true) {
                // Client 문자 받기
                String received = input.readUTF();
                log("client -> server: " + received);
                if ("exit".equals(received)) {
                    break;
                }

                // Client에 문자 보내기
                String toSend = received + " World!";
                output.writeUTF(toSend);
                log("client <- server: " + toSend);
            }
        } catch (IOException e) {
            log(e);
        }
        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }

}
