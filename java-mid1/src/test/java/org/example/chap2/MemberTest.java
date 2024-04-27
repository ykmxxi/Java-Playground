package org.example.chap2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void 가변객체_멤버변수() {
        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("회원A", address);
        MemberV1 memberB = new MemberV1("회원B", address);

        assertThat(memberA.getAddress().getValue()).isEqualTo("서울");
        assertThat(memberB.getAddress().getValue()).isEqualTo("서울");

        // 회원B 주소를 변경해야 한다면
        memberB.getAddress().setValue("부산");

        // 회원A 주소도 변경된다: 가변 객체 사용으로 공유 참조 문제 발생
        assertThat(memberA.getAddress().getValue()).isEqualTo("부산");
        assertThat(memberB.getAddress().getValue()).isEqualTo("부산");
    }

    @Test
    @DisplayName("불변 객체를 멤버 변수로 사용해 공유 참조 문제를 해결한다")
    void 불변객체_멤버변수() {
        ImmutableAddress address = new ImmutableAddress("서울");

        MemberV2 memberA = new MemberV2("회원A", address);
        MemberV2 memberB = new MemberV2("회원B", address);

        assertThat(memberA.getAddress().getValue()).isEqualTo("서울");
        assertThat(memberB.getAddress().getValue()).isEqualTo("서울");

        // 회원B 주소를 변경해야 한다면
        memberB.setAddress(new ImmutableAddress("부산"));

        // 회원A 주소도 변경된다: 가변 객체 사용으로 공유 참조 문제 발생
        assertThat(memberA.getAddress().getValue()).isEqualTo("서울");
        assertThat(memberB.getAddress().getValue()).isEqualTo("부산");
    }

}
