package org.example.chap9.map;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    private final Map<String, Member> members;

    public MemberRepository() {
        members = new HashMap<>();
    }

    public void save(final Member member) {
        members.put(member.getId(), member);
    }

    public Member findById(final String id) {
        return members.get(id);
    }

    public Member findByName(final String name) {
        for (Member member : members.values()) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void remove(final String id) {
        members.remove(id);
    }

}
