package org.example.chap5.problem;

public enum AuthGrade {

    GUEST(1, "손님"), LOGIN(2, "로그인 회원"), ADMIN(3, "관리자");

    private final int level;
    private final String description;

    AuthGrade(final int level, final String description) {
        this.level = level;
        this.description = description;
    }

    public static int matchLevel(final String grade) {
        return AuthGrade.valueOf(grade).level;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

}
