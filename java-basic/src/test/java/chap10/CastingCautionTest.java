package chap10;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CastingCautionTest {

    @DisplayName("자식 타입의 인스턴스는 생성되지 않아 다운캐스팅떄 주의해야 한다")
    @Test
    void downCasting() {
        // given
        Parent parent = new Parent();

        // when & then
        assertThatThrownBy(() -> {
            Child child = (Child) parent;
            child.childMethod();
        }).isInstanceOf(ClassCastException.class);
    }

    @DisplayName("부모 타입의 인스턴스는 모두 생성되기 때문에 업캐스팅은 생략 가능하다")
    @Test
    void upCasting() {
        // given
        Child child = new Child();

        // when & then
        assertThatCode(() -> {
            Parent parent = child;
            parent.parentMethod();
        }).doesNotThrowAnyException();
    }

}
