package org.example.chap8;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocalClassTest {

    @Test
    void ex1() {
        LocalOuterV1 localOuterV1 = new LocalOuterV1();
        localOuterV1.process(2);
    }

    @Test
    @DisplayName("이미 제거된 지역 변수의 출력이 가능하다? -> 지역 변수 캡처")
    void ex2() {
        LocalOuterV2 localOuterV2 = new LocalOuterV2();
        Printer printer = localOuterV2.process(2);
        printer.print();

        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }

}
