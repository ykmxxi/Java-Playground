package org.example.chap9.checked;

/**
 * Checked 예외는
 * 예외를 잡아서 처리하거나, 던지거나 둘중 하나를 필수로 선택해야 한다.
 */
public class Service {

    Client client = new Client();

    /**
     * 체크 예외를 잡아서 해결
     */
    public void callCatch() {
        try {
            client.call();
        } catch (MyCheckedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("정상 흐름");
    }

    /**
     * 체크 예외를 밖으로 던짐
     */
    public void catchThrow() throws MyCheckedException {
        client.call();
    }

}
