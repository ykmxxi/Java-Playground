package chap10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InstanceofTest {

    @Test
    void instanceofTest() {
        // given
        Parent parent1 = new Parent();
        Parent parent2 = new Child();

        // when & then
        assertThat(parent1 instanceof Child).isFalse();
        assertThat(parent2 instanceof Child).isTrue();
    }

    @Test
    void 상속관계_instanceof() {
        assertThat(new Parent() instanceof Parent).isTrue(); // Parent 타입에 Parent 인스턴스가 들어갈 수 있다
        assertThat(new Parent() instanceof Child).isFalse(); // Child 타입에 Parent 인스턴스가 들어갈 수 없다

        assertThat(new Child() instanceof Parent).isTrue(); // Parent 타입에 Child 인스턴스가 들어갈 수 있다
        assertThat(new Child() instanceof Child).isTrue(); // Child 타입에 Child 인스턴스가 들어갈 수 있다
    }

    @Test
    void 인터페이스_instanceof() {
        assertThat(new Dog() instanceof Dog).isTrue();
        assertThat(new Dog() instanceof Animal).isTrue();
    }

}
