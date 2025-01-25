package chat.client;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import network.tcp.SocketCloseUtil;

public class ChatClient {

    private final String host;
    private final int port;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    private ReadHandler readHandler;
    private WriterHandler writerHandler;
    private boolean closed = false;

    public ChatClient(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        log("클라이언트 시작");
        socket = new Socket(host, port);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

        readHandler = new ReadHandler(this, input);
        writerHandler = new WriterHandler(this, output);
        Thread readThread = new Thread(readHandler, "readHandler");
        Thread writerThread = new Thread(writerHandler, "writerHandler");
        readThread.start();
        writerThread.start();
    }

    public synchronized void close() {
        if (closed) {
            return;
        }
        writerHandler.close();
        readHandler.close();
        SocketCloseUtil.closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket);
    }

}
