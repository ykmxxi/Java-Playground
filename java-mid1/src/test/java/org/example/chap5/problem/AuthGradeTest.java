package org.example.chap5.problem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AuthGradeTest {

    @Test
    @DisplayName("grade={}, level={}, 설명={} 형식으로 출력")
    void problem1() {
        AuthGrade[] authGrades = AuthGrade.values();

        for (AuthGrade authGrade : authGrades) {
            System.out.println("grade=" + authGrade.name() + ", level=" + authGrade.getLevel() + ", 설명="
                    + authGrade.getDescription());
        }
    }

}
