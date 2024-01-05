package chap12.problem1;

public class FaceBookSender implements Sender {

    private static final String SEND_NOTIFICATION = "페이스북에 발송합니다";

    @Override
    public void sendMessage(final String message) {
        System.out.println(String.join(": ", SEND_NOTIFICATION, message));
    }

}
