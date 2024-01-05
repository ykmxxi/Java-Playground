package chap12.problem1;

/**
 * 다형성을 활용
 * Sender 인터페이스 사용
 * EmailSender, SmsSender, FaceBookSender
 */
public class SenderMain {

    public static void main(String[] args) {
        Sender[] senders = {new EmailSender(), new SmsSender(), new FaceBookSender()};

        for (Sender sender : senders) {
            sender.sendMessage("환영합니다!");
        }
    }

}
