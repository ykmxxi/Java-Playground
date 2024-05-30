package org.example.chap9.ex1;

public class NetworkServiceV1_1 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        client.connect();
        client.send(data);
        client.disconnect();
    }

}
