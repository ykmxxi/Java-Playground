package org.example.chap9.ex0;

public class NetworkServiceV0 {

    public void sendMessage(final String data) {
        String address = "http://localhost:8080";
        NetworkClientV0 client = new NetworkClientV0(address);

        client.connect();
        client.send(data);
        client.disconnect();
    }

}
