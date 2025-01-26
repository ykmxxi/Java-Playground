package chat.server;

import java.io.IOException;

public interface CommandManager {

    void execute(final String received, final Session session) throws IOException;

}
