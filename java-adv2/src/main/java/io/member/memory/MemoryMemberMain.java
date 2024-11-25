package io.member.memory;

import io.member.MemoryMemberClient;

public class MemoryMemberMain {

    public static void main(String[] args) {
        MemoryMemberClient memoryMemberClient = new MemoryMemberClient(new MemoryMemberRepository());
        memoryMemberClient.run();
    }

}
