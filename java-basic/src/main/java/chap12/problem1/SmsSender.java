package chap12.problem1;

public class SmsSender implements Sender {

    private static final String SEND_NOTIFICATION = "SMS를 발송합니다.";

    @Override
    public void sendMessage(final String message) {
        System.out.println(String.join(": ", SEND_NOTIFICATION, message));
    }

}
