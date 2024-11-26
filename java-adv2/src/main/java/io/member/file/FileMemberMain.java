package io.member.file;

import io.member.MemberClient;

public class FileMemberMain {

    public static void main(String[] args) {
        MemberClient memberClient = new MemberClient(new FileMemberRepository());
        memberClient.run();
    }

}
