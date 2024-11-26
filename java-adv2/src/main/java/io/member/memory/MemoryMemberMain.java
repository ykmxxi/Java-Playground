package io.member.memory;

import io.member.MemberClient;

public class MemoryMemberMain {

    public static void main(String[] args) {
        MemberClient memberClient = new MemberClient(new MemoryMemberRepository());
        memberClient.run();
    }

}
