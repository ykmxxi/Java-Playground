package org.example.chap9.checked;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckedExceptionTest {

    @Test
    @DisplayName("예외를 잡아서 처리하는 경우: 예외 처리 로직이 실행되고 정상 흐름으로 돌아온다")
    void catchException() {
        Service service = new Service();

        service.callCatch();
    }

    @Test
    @DisplayName("예외를 던지는 경우: main() 까지 올라와 던지면 스택 트레이스가 출력되고 프로그램 종료")
    void throwException() throws Exception {
        Service service = new Service();

        assertThatThrownBy(service::catchThrow)
                .isInstanceOf(MyCheckedException.class);
    }

}
