package chap11;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chap11.ex.SubClass;
import chap11.ex.SuperClass;

class PolyTest {

    @DisplayName("상속 관계에서 오버라이딩 된 메서드가 우선권을 갖는다")
    @Test
    void 다형성() {
        SuperClass superClass = new SubClass();

        assertThat(superClass.value).isEqualTo("parent");
        assertThat(superClass.get()).isEqualTo("sub");
    }

    @Test
    void 상속관계() {
        SuperClass sup= new SuperClass();
        SubClass sub = new SubClass();
        SuperClass poly = new SubClass();

        assertThat(sup.value).isEqualTo("parent");
        assertThat(sub.value).isEqualTo("child");
        assertThat(poly.value).isEqualTo("parent");
    }

}
