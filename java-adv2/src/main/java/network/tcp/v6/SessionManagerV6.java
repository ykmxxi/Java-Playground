package network.tcp.v6;

import java.util.ArrayList;
import java.util.List;

// 동시성 처리 필요
public class SessionManagerV6 {

    private final List<SessionV6> sessions = new ArrayList<>();

    public synchronized void add(final SessionV6 session) {
        sessions.add(session);
    }

    public synchronized void remove(final SessionV6 session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (SessionV6 session : sessions) {
            session.close();
        }
        sessions.clear();
    }

}
