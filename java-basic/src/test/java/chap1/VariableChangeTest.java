package chap1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class VariableChangeTest {

    private static final Logger log = LoggerFactory.getLogger(VariableChangeTest.class);

    @Test
    void 기본_형_값_대입() {
        int a = 10;
        int b = a;

        assertThat(a).isEqualTo(10);
        assertThat(b).isEqualTo(10);

        a = 20;

        assertThat(a).isEqualTo(20);
        assertThat(b).isEqualTo(10);

        b = 30;

        assertThat(a).isEqualTo(20);
        assertThat(b).isEqualTo(30);
    }

    @Test
    void 참조형_값_대입() {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        log.info("dataA 참조 값: [{}]", dataA); // chap1.VariableChangeTest$Data@14a2f921
        log.info("dataB 참조 값: [{}]", dataB); // chap1.VariableChangeTest$Data@14a2f921
        assertThat(dataA.value).isEqualTo(10);
        assertThat(dataB.value).isEqualTo(10);

        dataA.value = 20;

        assertThat(dataA.value).isEqualTo(20);
        assertThat(dataB.value).isEqualTo(20);

        dataB.value = 30;

        assertThat(dataA.value).isEqualTo(30);
        assertThat(dataB.value).isEqualTo(30);
    }

    static class Data {

        int value;

    }

}
