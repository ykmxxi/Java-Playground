package chap11.diamond;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiamondTest {

    @DisplayName("오버라이딩 메서드가 우선권을 가져 다중 구현시 다이아몬드 문제 발생 X")
    @Test
    void 다이아몬드_문제() {
        A a = new C();
        B b = new C();
        C c = new C();

        assertThat(a.methodA()).isEqualTo("a");
        assertThat(a.common()).isEqualTo("c");

        assertThat(b.methodB()).isEqualTo("b");
        assertThat(b.common()).isEqualTo("c");

        assertThat(c.methodA()).isEqualTo("a");
        assertThat(c.methodB()).isEqualTo("b");
        assertThat(c.common()).isEqualTo("c");
    }

}
