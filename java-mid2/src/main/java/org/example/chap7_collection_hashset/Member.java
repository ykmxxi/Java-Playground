package org.example.chap7_collection_hashset;

import java.util.Objects;

public class Member {

    private final String id;

    public Member(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Member member = (Member) object;
        return Objects.equals(getId(), member.getId());
    }

    @Override
    public int hashCode() {
        // 해시 코드로 사용할 값을 지정해주면 쉽게 해시 코드를 생성
        // 재정의하지 않으면 Object의 기본 구현을 사용해 참조값을 기반으로 해시 코드 생성 -> 동일성
        return Objects.hash(getId()); // id 값을 기반으로 해시 코들 생성 -> 동등성
    }

}
