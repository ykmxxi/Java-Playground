package org.example.chap1_generic;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Object 다형성을 사용하면 발생하는 문제점
 */
class ObjectBoxTest {

    @Test
    @DisplayName("문제점 1: 반환 타입이 맞지 않는 문제")
    void problem1() {
        ObjectBox box = new ObjectBox();

        box.setValue(10);

        // Integer value = box.getValue(); // 컴파일 오류
        // 직접 다운 캐스팅해야 한다
        Integer value = (Integer) box.getValue();
    }

    @Test
    @DisplayName("문제점 2: 잘못된 타입의 인수 전달 문제")
    void problem2() {
        ObjectBox box = new ObjectBox();

        box.setValue("100"); // Integer 값을 보관할 의도로 사용해도 잘못된 인수 타입을 전달하는 상황을 못막음

        assertThatThrownBy(() -> {
            Integer integer = (Integer) box.getValue();
        }).isInstanceOf(ClassCastException.class);
    }

}
