package org.example.oop.encapsulation.ex1;

public class AuthController {

    private PasswordEncoder passwordEncoder;

    public AuthController(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResult authenticate(final String id, final String pw) {
        Member member = findOne(id);

        if (member == null) {
            return AuthResult.NO_MATCH;
        }
        // Tell, Don't Ask 적용, 데이터를 요청하지 않고 물어보자
//        if (member.getEmailStatus() != 2) {
//            return AuthResult.NO_EMAIL_VERIFIED;
//        }
        if (!member.isEmailVerified()) {
            return AuthResult.NO_EMAIL_VERIFIED;
        }
        if (passwordEncoder.isPasswordValid(member.getPassword(), pw, member.getId())) {
            return AuthResult.SUCCESS;
        }
        return AuthResult.NO_MATCH;
    }

    private Member findOne(final String id) {
        return new Member(id, "pw", 2);
    }

}
