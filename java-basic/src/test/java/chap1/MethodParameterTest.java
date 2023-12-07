package chap1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import chap1.VariableChangeTest.Data;

class MethodParameterTest {

    @Test
    void 기본형_메서드_호출() {
        int x = 10;

        assertThat(x).isEqualTo(10);

        changePrimitiveType(x);

        assertThat(x).isEqualTo(10);
    }

    void changePrimitiveType(int x) {
        x = 20;
    }

    @Test
    void 참조형_메서드_호출() {
        Data dataA = new Data();
        dataA.value = 10;

        assertThat(dataA.value).isEqualTo(10);

        // 참조값을 넘겨주기 때문에 메서드에서 값을 변경하면 원본에 영향을 미침
        changeReferenceType(dataA);

        assertThat(dataA.value).isEqualTo(20);
    }

    void changeReferenceType(Data data) {
        data.value = 20;
    }

}
