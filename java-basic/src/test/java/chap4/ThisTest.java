package chap4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThisTest {

    @Test
    @DisplayName("멤버 변수와 매개변수의 이름이 같으면 메서드 내에서 매개변수가 높은 우선권을 갖는다.")
    void this_키워드_테스트() {
        Member member = new Member();
        member.initMember("회원1", 20, 90);

        assertThat(member.name).isEqualTo("회원1");
        assertThat(member.age).isEqualTo(0);
        assertThat(member.grade).isEqualTo(90);
    }

    static class Member {

        String name;
        int age;
        int grade;

        void initMember(String name, int age, int grade) {
            this.name = name;
            age = age;
            this.grade = grade;
        }

    }

}
