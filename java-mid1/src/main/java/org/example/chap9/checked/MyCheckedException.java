package org.example.chap9.checked;

/**
 * Exception을 상속 받은 예외는 체크 예외(Checked Exception)
 */
public class MyCheckedException extends Exception {

    public MyCheckedException(final String message) {
        super(message);
    }

}
