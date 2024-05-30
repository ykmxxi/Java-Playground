package org.example.chap9.checked;

public class Client {

    // 밖으로 예외를 던짐
    public void call() throws MyCheckedException {
        throw new MyCheckedException("exception");
    }

}
