package network.exception.close.normal;

import static util.MyLogger.log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class NormalCloseClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream();

        readByInputStream(input, socket);
        readByBufferedReader(input, socket);
        readByDataInputStream(input, socket);

        log("연결 종료: " + socket.isClosed());
    }

    private static void readByInputStream(final InputStream input, final Socket socket) throws IOException {
        int read = input.read(); // 1byte 단위로 읽음
        log("read = " + read);
        if (read == -1) {
            input.close();
            socket.close();
        }
    }

    private static void readByBufferedReader(final InputStream input, final Socket socket) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        String readString = bufferedReader.readLine(); // 라인 단위로 String로 읽음
        log("readString = " + readString);
        if (readString == null) {
            bufferedReader.close();
            socket.close();
        }
    }

    private static void readByDataInputStream(final InputStream input, final Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(input);
        try {
            dis.readUTF(); // DataInputStream을 통해 String로 읽음
        } catch (EOFException e) {
            log(e);
        } finally {
            dis.close();
            socket.close();
        }
    }

}
