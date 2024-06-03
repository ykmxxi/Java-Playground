package org.example.chap9.ex4;

public class NetworkServiceV4 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV4 client = new NetworkClientV4(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } finally {
            client.disconnect();
        }
    }

}
