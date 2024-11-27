package io.member.object;

import io.member.MemberClient;

public class ObjectMemberMain {

    public static void main(String[] args) {
        MemberClient memberClient = new MemberClient(new ObjectMemberRepository());
        memberClient.run();
    }

}
