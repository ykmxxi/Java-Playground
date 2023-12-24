package chap10;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class DownCastingTest {

    @Test
    void 다운캐스팅() {
        // given
        Parent poly = new Child();

        // when
        Child child = (Child) poly;

        // then
        assertThatCode(child::childMethod)
                .doesNotThrowAnyException();
    }

}
