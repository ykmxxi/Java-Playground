package org.example.chap5.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TypeSafeEnumPatternServiceTest {

    private final TypeSafeEnumPatternService service = new TypeSafeEnumPatternService();

    @Test
    @DisplayName("타입 안전 열거형 패턴 도입")
    void test() {
        // 외부에서 ClassGrade 인스턴스 생성 막음
        // ClassGrade VIP = new ClassGrade(); // 컴파일 오류
        int price = 10_000;

        assertThat(service.discount(ClassGrade.BASIC, price)).isEqualTo(1_000);
        assertThat(service.discount(ClassGrade.GOLD, price)).isEqualTo(2_000);
        assertThat(service.discount(ClassGrade.DIAMOND, price)).isEqualTo(3_000);
    }

}
