package io.member;

import java.util.List;

public class OutputView {

    public void printMemberAddSuccess() {
        System.out.println("회원이 성공적으로 등록되었습니다.");
        System.out.println();
    }

    public void printMembers(final List<Member> members) {
        System.out.println("회원 목록:");
        members.forEach(member -> {
            System.out.printf("[ID: %s, Name: %s, Age: %d]" + System.lineSeparator(),
                    member.id(), member.name(), member.age());
        });
        System.out.println();
    }

    public void printEndMessage() {
        System.out.println("프로그램을 종료합니다.");
    }

}
