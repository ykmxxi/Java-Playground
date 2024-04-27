package org.example.chap2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImmutableObjectTest {

    @Test
    @DisplayName("불변 객체도 공유 참조는 가능하다. 단, 인스턴스 값을 변경하는 것이 불가능")
    void 불변객체() {
        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a;

        assertThat(a.getValue()).isEqualTo("서울");
        assertThat(b.getValue()).isEqualTo("서울");

        b = new ImmutableAddress("광주");

        assertThat(a.getValue()).isEqualTo("서울");
        assertThat(b.getValue()).isEqualTo("광주");
    }

    @Test
    @DisplayName("불변 객체에서 변경과 관련된 메서드들은 새로운 객체를 만들어서 반환하기 때문에 꼭 반환 값을 받아야 한다.")
    void 불변객체_값변경() {
        ImmutableObject immutableObject1 = new ImmutableObject(10);
        ImmutableObject immutableObject2 = immutableObject1.add(20);

        assertThat(immutableObject1.getValue()).isEqualTo(10);
        assertThat(immutableObject2.getValue()).isEqualTo(30);
    }

}
