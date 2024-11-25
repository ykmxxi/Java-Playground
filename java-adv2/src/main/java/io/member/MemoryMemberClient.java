package io.member;

import java.util.List;

public class MemoryMemberClient {

    private final MemberRepository memberRepository;
    private final InputView inputView;
    private final OutputView outputView;

    public MemoryMemberClient(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        while (true) {
            int choice = readChoice();
            if (isAddMember(choice)) {
                addMember();
            }
            if (isFindAll(choice)) {
                findAll();
            }
            if (isEnd(choice)) {
                outputView.printEndMessage();
                break;
            }
        }
    }

    private int readChoice() {
        while (true) {
            try {
                return inputView.readChoice();
            } catch (IllegalArgumentException e) {
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    private boolean isAddMember(final int choice) {
        return choice == 1;
    }

    private boolean isFindAll(final int choice) {
        return choice == 2;
    }

    private boolean isEnd(final int choice) {
        return choice == 3;
    }

    private void addMember() {
        String id = inputView.readId();
        String name = inputView.readName();
        int age = inputView.readAge();

        Member member = new Member(id, name, age);
        memberRepository.add(member);
        outputView.printMemberAddSuccess();
    }

    private void findAll() {
        List<Member> members = memberRepository.findAll();
        outputView.printMembers(members);
    }

}
