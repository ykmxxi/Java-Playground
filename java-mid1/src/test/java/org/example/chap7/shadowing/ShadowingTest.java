package org.example.chap7.shadowing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShadowingTest {

    private final int value = 1;

    class Inner {

        private final int value = 2;

        public void go() {
            int value = 3;

            System.out.println(value); // 3, 지역 변수
            System.out.println(this.value); // 2, 내부 클래스의 인스턴스 변수
            System.out.println(ShadowingTest.this.value); // 1, 외부 클래스의 인스턴스 변수
        }

    }

    @Test
    @DisplayName("Shadowing: 다른 변수들을 가려서 보이지 않게 만드는 것, 우선순위는 구체적이고 가까운 것이 높음")
    void shadowing() {
        ShadowingTest test = new ShadowingTest();
        Inner inner = test.new Inner();

        inner.go(); // 3, 2, 1 차례대로 출력
    }

}
