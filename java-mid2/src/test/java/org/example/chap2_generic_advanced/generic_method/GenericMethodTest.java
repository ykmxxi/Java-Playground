package org.example.chap2_generic_advanced.generic_method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenericMethodTest {

    @Test
    @DisplayName("제네릭 메서드 호출: 명시적 타입 인자 전달")
    void 명시적_타입_인자_전달() {
        Integer integer = 10;

        Integer result1 = GenericMethod.<Integer>genericMethod(integer);
        Integer result2 = GenericMethod.<Integer>numberMethod(integer);

        String result3 = GenericMethod.<String>genericMethod("hello");
        // String result4 = GenericMethod.<String>numberMethod("hello"); // 컴파일 에러
    }

    @Test
    @DisplayName("제네릭 메서드 타입 추론: 반환 타입이나 전달된 인수의 타입을 통해 컴파일러가 추론")
    void 제네릭_메서드_타입_추론() {
        Integer result1 = GenericMethod.genericMethod(10);
        String result2 = GenericMethod.genericMethod("hello");
        Double result3 = GenericMethod.numberMethod(10.0);
    }

}
