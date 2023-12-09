package chap2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NullExceptionTest {

    @Test
    void 널_포인트_예외() {
        BigData bigData = new BigData();

        assertThat(bigData.count).isEqualTo(0);
        assertThat(bigData.data).isNull();
        assertThatCode(() -> System.out.println(bigData.data))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> System.out.println(bigData.data.value))
                .isInstanceOf(NullPointerException.class);
    }

    static class BigData {

        Data data;
        int count;

    }

    static class Data {

        int value;

    }

}
