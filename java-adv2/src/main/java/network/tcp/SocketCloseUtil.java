package network.tcp;

import static util.MyLogger.log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketCloseUtil {

    public static void closeAll(final Socket socket, final InputStream input, final OutputStream output) {
        // input, output 해제 순서는 상관 X, Socket 마지막에 닫아주면 O
        close(input);
        close(output);

        close(socket);
    }

    public static void close(final InputStream input) {
        if (input != null) { // not null
            try {
                input.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(final OutputStream output) {
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(final Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

}
