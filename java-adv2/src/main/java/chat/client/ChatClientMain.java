package chat.client;

import java.io.IOException;

import chat.common.Network;

public class ChatClientMain {

    public static void main(String[] args) throws IOException {
        ChatClient chatClient = new ChatClient("localhost", Network.PORT.value());
        chatClient.start();
    }

}
