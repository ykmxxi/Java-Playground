package io.member.memory;

import java.util.ArrayList;
import java.util.List;

import io.member.Member;
import io.member.MemberRepository;

public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();

    @Override
    public void add(final Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return members.stream()
                .toList();
    }

}
