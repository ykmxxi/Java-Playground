package chap12.problem1;

public class EmailSender implements Sender {

    private static final String SEND_NOTIFICATION = "메일을 발송합니다";

    @Override
    public void sendMessage(final String message) {
        System.out.println(String.join(": ", SEND_NOTIFICATION, message));
    }

}
