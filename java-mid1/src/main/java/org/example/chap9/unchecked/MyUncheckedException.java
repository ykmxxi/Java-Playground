package org.example.chap9.unchecked;

/**
 * RuntimeException을 상속받은 예외는 언체크 예외(Unchecked Exception)
 */
public class MyUncheckedException extends RuntimeException {

    public MyUncheckedException(final String message) {
        super(message);
    }

}
