package chat.server;

import java.io.IOException;

import chat.common.Network;
import chat.server.command.CommandManagerV1;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommandManager commandManager = new CommandManagerV1(sessionManager);
        Server server = new Server(Network.PORT.value(), commandManager, sessionManager);
        server.start();
    }

}
