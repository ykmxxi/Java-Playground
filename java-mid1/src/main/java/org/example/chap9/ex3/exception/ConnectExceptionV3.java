package org.example.chap9.ex3.exception;

public class ConnectExceptionV3 extends NetworkClientExceptionV3 {

    private final String address;

    public ConnectExceptionV3(final String message, final String address) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}
