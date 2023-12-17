package 상속;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PolymorphismTest {

    @DisplayName("상위 클래스 타입을 사용해도 하위 클래스에서 오버라이딩한 메서드가 호출된다.")
    @Test
    void 오버라이딩_테스트() {
        // given
        SuperClass superClass = new SuperClass();
        SuperClass superType = new SubClass();
        SubClass subType = new SubClass();

        // when & then
        assertThat(superClass.method()).isEqualTo("super");
        assertThat(superType.method()).isEqualTo("sub");
        assertThat(subType.method()).isEqualTo("sub");
        assertThat(subType.method("hi")).isEqualTo("hi sub");
    }

    static class SuperClass {

        public String method() {
            return "super";
        }

    }

    static class SubClass extends SuperClass {

        @Override
        public String method() {
            return "sub";
        }

        public String method(String str) {
            return String.join(" ", str, method());
        }

    }


}
