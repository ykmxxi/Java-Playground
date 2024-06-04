package org.example.chap1_generic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenericBoxTest {

    @Test
    @DisplayName("제네릭: 객체 생성 시점에 타입을 지정")
    void 제네릭_생성() {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        GenericBox<String> stringBox = new GenericBox<String>();
        GenericBox<Double> doubleBox = new GenericBox<Double>();

        integerBox.setValue(10);
        stringBox.setValue("10");
        doubleBox.setValue(10.0);

        // 별도의 타입 캐스팅이 필요가 없음
        assertThat(integerBox.getValue()).isExactlyInstanceOf(Integer.class);
        assertThat(stringBox.getValue()).isExactlyInstanceOf(String.class);
        assertThat(doubleBox.getValue()).isExactlyInstanceOf(Double.class);
    }

    @Test
    @DisplayName("타입 안전성: Object와 달리 잘못된 인수 전달을 막을 수 있다")
    void 타입_안전성() {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();

        integerBox.setValue(10);
        // integerBox.setValue("10"); // 컴파일 오류 발생

        assertThat(integerBox.getValue()).isEqualTo(10);
    }

    @Test
    @DisplayName("자바 컴파일러가 타입 추론이 가능한 상황에서 생성자에 타입을 생략 가능")
    void 타입_추론() {
        GenericBox<Integer> integerBox = new GenericBox<>();

        assertThatCode(() -> integerBox.setValue(10))
                .doesNotThrowAnyException();
    }

}
