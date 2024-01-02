package chap11.interface_ex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InterfaceTest {

    @DisplayName("인터페이스의 멤버 변수는 상수이다")
    @Test
    void 멤버변수() {
        assertThat(MyInterface.PI).isEqualTo(3.14);
    }

}
