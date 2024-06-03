package org.example.chap9.ex4.exception;

public class SendExceptionV4 extends NetworkClientExceptionV4 {

    private final String sendData;

    public SendExceptionV4(final String message, final String sendData) {
        super(message);
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }

}
