package org.example.unit_test.chap07;

public class MessageBus {

    public void sendEmailChangedMessage(final Long userId, final String email) {
        System.out.println("To: " + email + " 이메일 전송 완료");
        System.out.println("UserId: " + userId);
    }

}
