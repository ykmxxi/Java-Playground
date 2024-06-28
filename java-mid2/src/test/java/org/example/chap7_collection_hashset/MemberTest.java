package org.example.chap7_collection_hashset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void hashcode() {
        Member member1 = new Member("A");
        Member member2 = new Member("A");

        assertThat(member1 == member2).isFalse();

        // id 값을 기반으로 해시 코드를 생성해 id가 같은 두 객체는 동등한 객체임
        System.out.println("member1.hashCode() = " + member1.hashCode());
        System.out.println("member2.hashCode() = " + member2.hashCode());
        assertThat(member1.hashCode()).isEqualTo(member2.hashCode());
    }

}
