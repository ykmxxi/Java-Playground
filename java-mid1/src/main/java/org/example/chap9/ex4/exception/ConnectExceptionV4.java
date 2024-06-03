package org.example.chap9.ex4.exception;

public class ConnectExceptionV4 extends NetworkClientExceptionV4 {

    private final String address;

    public ConnectExceptionV4(final String message, final String address) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}
