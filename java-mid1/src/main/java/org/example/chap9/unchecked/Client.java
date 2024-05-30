package org.example.chap9.unchecked;

public class Client {

    public void call() {
        throw new MyUncheckedException("ex");
    }

}
