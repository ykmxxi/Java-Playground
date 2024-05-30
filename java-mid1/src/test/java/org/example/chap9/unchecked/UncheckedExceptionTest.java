package org.example.chap9.unchecked;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UncheckedExceptionTest {

    @Test
    @DisplayName("언체크 예외 잡아서 처리: 체크 예외와 똑같이 예외를 처리하고 정상 흐름으로 동작")
    void callCatch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    @DisplayName("언체크 예외 던지기: throws 생략해도 상관 없음")
    void test() {
        Service service = new Service();

        assertThatThrownBy(service::callThrow)
                .isInstanceOf(MyUncheckedException.class);
    }

}
