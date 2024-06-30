package org.example.chap7_collection_hashset;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HashCodeEqualsTest {

    @Test
    @DisplayName("equals & hashCode 둘다 구현하지 않은 경우")
    void noHashNoEq() {
        MyHashSetV2 set = new MyHashSetV2();
        MemberNoHashNoEq member1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq member2 = new MemberNoHashNoEq("A");
        set.add(member1);
        set.add(member2);

        System.out.println("set = " + set);

        assertThat(member1.hashCode()).isNotEqualTo(member2.hashCode());
        // 같은 id를 가진 회원도 다른 회원으로 취급
        assertThat(member1.equals(member2)).isFalse();
        assertThat(set.size()).isEqualTo(2);

        // 검색 실패: set에 없는 회원이라고 나옴
        assertThat(set.contains(new MemberNoHashNoEq("A"))).isFalse();
    }

    @Test
    @DisplayName("hashCode만 구현한 경우")
    void onlyHash() {
        MyHashSetV2 set = new MyHashSetV2();
        MemberOnlyHash member1 = new MemberOnlyHash("A");
        MemberOnlyHash member2 = new MemberOnlyHash("A");

        set.add(member1);
        set.add(member2);

        System.out.println("set = " + set);
        // 데이터 중복 저장 문제 발생, 같은 해시 인덱스에 저장되지만 중복 저장
        assertThat(member1.hashCode()).isEqualTo(member2.hashCode());
        // 같은 id를 가진 회원도 다른 회원으로 취급
        assertThat(member1.equals(member2)).isFalse();
        // 검색 실패: set에 없는 회원이라고 나옴
        assertThat(set.contains(new MemberOnlyHash("A"))).isFalse();
    }

    @Test
    @DisplayName("equals & hashCode 둘 다 구현한 경우")
    void implHashCodeEquals() {
        MyHashSetV2 set = new MyHashSetV2();
        Member member1 = new Member("A");
        Member member2 = new Member("A");

        set.add(member1);
        set.add(member2);

        System.out.println("set = " + set);
        assertThat(member1.hashCode()).isEqualTo(member2.hashCode());

        // 데이터 중복 저장 X, 똑같은 id를 가진 회원을 동일한 회원으로 취급
        assertThat(set.size()).isEqualTo(1);
        assertThat(member1.equals(member2)).isTrue();

        // 검색 성공
        assertThat(set.contains(new Member("A"))).isTrue();
    }

}
