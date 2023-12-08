package chap2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VariableInitTest {

    @Test
    @DisplayName("멤버 변수는 자동 초기화 된다.")
    void 멤버_변수_초기화() {
        Data data = new Data();

        assertThat(data.number).isEqualTo(0); // 숫자 기본형 멤버 변수는 0으로 자동 초기화
        assertThat(data.manualInit).isEqualTo(10); // 멤버 변수는 직접 초기화도 가능
        assertThat(data.flag).isFalse(); // boolean 멤버 변수는 기본 값 false로 자동 초기화
        assertThat(data.student).isNull(); // 참조형 멤버 변수는 null로 자동 초기화
    }

    static class Data {

        int number;
        int manualInit = 10;
        boolean flag;
        Student student;

    }

}
