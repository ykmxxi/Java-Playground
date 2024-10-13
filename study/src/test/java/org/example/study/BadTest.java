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

    @Test
    @DisplayName("코드 오염 문제: 테스트에만 필요한 제품 코드 추가")
    void codePollution() {
        Customer customer = new Customer();

        customer.check("VIP");

        assertThat(customer.state()).isTrue();
    }

    private static class Calculator {

        public int sum(int preOperand, int postOperand) {
            return preOperand + postOperand;
        }

    }

    private static class Customer {

        private boolean state = false;

        public void check(String grade) {
            if (grade.equals("VIP")) {
                state = true;
            }
        }

        // 불필요한 제품 코드 추가: 비공개 정보인 state를 테스트에 확인하려 getter 추가
        public boolean state() {
            return state;
        }

    }

}
