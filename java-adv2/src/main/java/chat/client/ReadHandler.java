package chat.client;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.IOException;

public class ReadHandler implements Runnable {

    private final ChatClient chatClient;
    private final DataInputStream input;
    private boolean closed = false;

    public ReadHandler(final ChatClient chatClient, final DataInputStream input) {
        this.chatClient = chatClient;
        this.input = input;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                System.out.println(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            chatClient.close();
        }
    }

    public synchronized void close() {
        if (closed) {
            return;
        }
        closed = true;
        log("ReadHandler 종료");
    }

}
