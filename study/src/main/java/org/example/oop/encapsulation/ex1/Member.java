package org.example.oop.encapsulation.ex1;

public class Member {

    private String id;
    private String password;
    private int emailStatus;

    public Member(final String id, final String password, final int emailStatus) {
        this.id = id;
        this.password = password;
        this.emailStatus = emailStatus;
    }

    public boolean isEmailVerified() {
        return emailStatus == 2;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

}
