package org.example.chap9.ex2;

public class NetworkClientExceptionV2 extends Exception {

    private final String errorCode;

    public NetworkClientExceptionV2(final String message, final String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
