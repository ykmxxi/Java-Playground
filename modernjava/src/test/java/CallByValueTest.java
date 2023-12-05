import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CallByValueTest {

    @DisplayName("기본 값(primitive type) call by value")
    @Test
    void 기본_값() {
        int x = 1;
        int y = 2;

        assertThat(x).isEqualTo(1);
        assertThat(y).isEqualTo(2);

        modify(x, y);

        assertThat(x).isEqualTo(1);
        assertThat(y).isEqualTo(2);
    }

    private void modify(int x, int y) {
        x = 10;
        y = 20;
    }

    @DisplayName("문자열(String) call by value")
    @Test
    void 문자열() {
        String abc = "abc";
        String efg = "efg";

        assertThat(abc).isEqualTo("abc");
        assertThat(efg).isEqualTo("efg");

        modify(abc, efg);

        assertThat(abc).isEqualTo("abc");
        assertThat(efg).isEqualTo("efg");
    }

    private void modify(String abc, String efg) {
        abc = "ABC";
        efg = "EFG";
    }

    @DisplayName("참조 형(wrapper class) call by value")
    @Test
    void 참조형() {
        Member member1 = new Member("이름1", 20);
        Member member2 = new Member("이름2", 30);

        assertThat(member1.name).isEqualTo("이름1");
        assertThat(member1.age).isEqualTo(20);
        assertThat(member2.name).isEqualTo("이름2");
        assertThat(member2.age).isEqualTo(30);

        modify(member1, member2);

        assertThat(member1.name).isEqualTo("이름1");
        assertThat(member1.age).isEqualTo(21);
        assertThat(member2.name).isEqualTo("이름2");
        assertThat(member2.age).isEqualTo(30);

    }

    private void modify(Member member1, Member member2) {
        member1.age = 21;
        member2 = new Member("이름3", 40);
    }

    static class Member {

        String name;
        int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

}
