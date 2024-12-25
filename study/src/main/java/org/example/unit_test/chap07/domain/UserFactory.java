package org.example.unit_test.chap07.domain;

public class UserFactory {

    public static User create(final Long userId, final String email, final UserType userType) {
        return new User(userId, email, userType);
    }
}
