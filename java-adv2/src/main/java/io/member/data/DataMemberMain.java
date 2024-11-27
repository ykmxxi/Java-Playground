package io.member.data;

import io.member.MemberClient;

public class DataMemberMain {

    public static void main(String[] args) {
        MemberClient memberClient = new MemberClient(new DataMemberRepository());
        memberClient.run();
    }

}
