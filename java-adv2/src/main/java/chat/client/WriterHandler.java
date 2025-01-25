package chat.client;

import static util.MyLogger.log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriterHandler implements Runnable {

    private static final String DELIMITER = "|";
    private final ChatClient chatClient;
    private final DataOutputStream output;
    private boolean closed = false;

    public WriterHandler(final ChatClient chatClient, final DataOutputStream output) {
        this.chatClient = chatClient;
        this.output = output;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            String username = inputUsername(scanner);
            output.writeUTF("/join" + DELIMITER + username);

            while (true) {
                String toSend = scanner.nextLine();
                if (toSend.isEmpty()) {
                    continue;
                }
                if ("/exit".equals(toSend)) {
                    output.writeUTF(toSend);
                    break;
                }

                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                    continue;
                }
                output.writeUTF("/message" + DELIMITER + toSend);
            }
        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            chatClient.close();
        }
    }

    private String inputUsername(final Scanner scanner) {
        System.out.println("이름을 입력하세요.");
        String username;
        do {
            username = scanner.nextLine();
        } while (username.isEmpty());
        return username;
    }

    public synchronized void close() {
        if (closed) {
            return;
        }
        closeScanner();
        closed = true;
        log("WriterHandler 종료");
    }

    private void closeScanner() {
        try {
            System.in.close();
        } catch (IOException e) {
            log(e);
        }
    }

}
