package chat.server.command;

import java.io.IOException;

import chat.server.CommandManager;
import chat.server.Session;
import chat.server.SessionManager;

public class CommandManagerV1 implements CommandManager {

    private final SessionManager sessionManager;

    public CommandManagerV1(final SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(final String received, final Session session) throws IOException {
        if (received.startsWith("/exit")) {
            throw new IOException("exit");
        }
        sessionManager.sendAll(received);
    }

}
