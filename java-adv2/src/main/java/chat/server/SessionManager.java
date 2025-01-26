package chat.server;

import static util.MyLogger.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SessionManager {

    private final List<Session> sessions = new ArrayList<>();

    public synchronized void add(final Session session) {
        sessions.add(session);
    }

    public synchronized void remove(final Session session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public void sendAll(final String message) {
        for (Session session : sessions) {
            try {
                session.send(message);
            } catch (IOException e) {
                log(e);
            }
        }
    }

    public synchronized List<String> getAllUsername() {
        return sessions.stream()
                .map(Session::getUsername)
                .filter(Objects::nonNull)
                .toList();
    }

}
