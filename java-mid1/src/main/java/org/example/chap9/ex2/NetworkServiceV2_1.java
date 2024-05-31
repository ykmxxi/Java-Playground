package org.example.chap9.ex2;

public class NetworkServiceV2_1 {

    public void sendMessage(final String data) throws NetworkClientExceptionV2 {
        String address = "http://localhost:8080";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        client.connect();
        client.send(data);
        client.disconnect();
    }

}
