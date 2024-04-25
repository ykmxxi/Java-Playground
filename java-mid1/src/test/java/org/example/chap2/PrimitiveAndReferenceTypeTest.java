package org.example.chap2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimitiveAndReferenceTypeTest {

    @Test
    @DisplayName("자바는 항상 값을 복사해서 대입, NumA의 값을 복사해서 NumB에 대입")
    void 기본형_공유() {
        int primitiveNumA = 10;
        int primitiveNumB = primitiveNumA;

        primitiveNumB += 10;

        assertThat(primitiveNumA).isEqualTo(10);
        assertThat(primitiveNumB).isEqualTo(20);
    }

    @Test
    @DisplayName("자바는 참조값을 복사해서 전달, 즉 같은 인스턴스를 참조하게 됨")
    void 참조형_공유() {
        Address addressA = new Address("서울");
        Address addressB = addressA;

        addressB.setValue("광주");

        assertThat(addressA.getValue()).isEqualTo("광주");
        assertThat(addressB.getValue()).isEqualTo("광주");

        assertThat(System.identityHashCode(addressA)).isEqualTo(System.identityHashCode(addressB));
    }

}
