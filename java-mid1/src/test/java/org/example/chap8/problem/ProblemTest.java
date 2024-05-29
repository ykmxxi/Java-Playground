package org.example.chap8.problem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProblemTest {

    @Test
    @DisplayName("1. 정적 중첩 클래스를 완성")
    void problem1() {
        // 정적 중첩 클래스를 생성하는데 바깥 클래스의 인스턴스는 필요 없음
        OuterClass1.NestedClass nestedClass = new OuterClass1.NestedClass();

        nestedClass.hello();
    }

    @Test
    @DisplayName("2. 내부 클래스 완성")
    void problem2() {
        // 내부 클래스를 생성하는데 바깥 클래스의 인스턴스가 필요
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass innerClass = outerClass2.new InnerClass();

        innerClass.hello();
    }

    @Test
    @DisplayName("3. 지역 클래스 완성")
    void problem3() {
        OuterClass3 outerClass3 = new OuterClass3();
        outerClass3.myMethod();
    }

    @Test
    @DisplayName("4. 익명 클래스 완성")
    void problem4() {
        AnonymousMain anonymousMain = new AnonymousMain();
        anonymousMain.hello();
    }

}
