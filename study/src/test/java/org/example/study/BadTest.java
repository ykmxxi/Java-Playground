package org.example.study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadTest {

    @Test
    @DisplayName("도메인 로직 유출")
    void leakedDomainLogic() {
        int num1 = 2;
        int num2 = 3;
        Calculator calculator = new Calculator();

        int result = calculator.sum(num1, num2);

        // 도메인 로직 유출
        assertThat(result).isEqualTo(num1 + num2);
    }

    @Test
    @DisplayName("도메인 로직 유출 해결")
    void leakedDomainLogicSolve() {
        int num1 = 2;
        int num2 = 3;
        Calculator calculator = new Calculator();

        int result = calculator.sum(num1, num2);

        // 도메인 로직 유출 문제 해결
        assertThat(result).isEqualTo(5); // 기대값 계산에 도메인 로직 유출을 방지
    }

    private static class Calculator {

        public int sum(int preOperand, int postOperand) {
            return preOperand + postOperand;
        }

    }

}
